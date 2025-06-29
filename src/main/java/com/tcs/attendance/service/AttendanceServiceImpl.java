package com.tcs.attendance.service;

import com.tcs.attendance.dto.AttendanceDto;
import com.tcs.attendance.dto.StudentDto;
import com.tcs.attendance.entity.Attendance;
import com.tcs.attendance.entity.Student;
import com.tcs.attendance.entity.Subject;
import com.tcs.attendance.repo.AttendanceRepo;
import com.tcs.attendance.repo.StudentRepo;
import com.tcs.attendance.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public void bulkAddAttendance(AttendanceDto dto) {
        Integer subjectId = dto.getSubjectId();
        Optional<Subject> subjectOptional = subjectRepo.findById(subjectId);
        if (subjectOptional.isEmpty()){
            throw new RuntimeException("Subject not found with id " + subjectId);
        }
        Subject subject = subjectOptional.get();
        List<StudentDto> studentList = dto.getStudentList();
        // check if attendance is already done
        // findBySubjectAndDate => if this returns any date then attendance is already one
        // throw exception
        for (StudentDto studentDto : studentList) {
            Optional<Student> studentOptional = studentRepo.findById(studentDto.getId());
            if (studentOptional.isEmpty()){
                throw new RuntimeException("Student not found with id " + studentDto.getId());
            }
            Student student = studentOptional.get();
            Attendance attendance = new Attendance();
            attendance.setStudent(student);
            attendance.setSubject(subject);
            attendance.setDate(dto.getAttendanceDate());
            attendance.setStatus(studentDto.getStatus());
            attendanceRepo.save(attendance);
        }
    }

    @Override
    public AttendanceDto getAttendanceBySubjectAndDate(Integer subjectId, LocalDate date) {
        List<Attendance> attendanceList = attendanceRepo.findBySubjectAndDate(subjectId, date);
        AttendanceDto dto=new AttendanceDto();
        List<StudentDto> studentDtos=new ArrayList<>();
        dto.setAttendanceDate(date);
        Subject subject = attendanceList.get(0).getSubject();
        dto.setSubjectId(subject.getId());
        dto.setSubjectName(subject.getName());
        for (Attendance attendance : attendanceList) {
            Student student = attendance.getStudent();
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setName(student.getName());
            studentDto.setStatus(attendance.getStatus());
            studentDtos.add(studentDto);
        }
        dto.setStudentList(studentDtos);
        return dto;
    }

    @Override
    public List<String> getAttendanceSubjectByDate(LocalDate date) {
        return attendanceRepo.findAllAttendanceSubjectByDate(date);
    }

}
