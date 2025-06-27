package com.tcs.attendance.service;

import com.tcs.attendance.dto.StudentDto;
import com.tcs.attendance.entity.Student;
import com.tcs.attendance.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<StudentDto> findStudentByFacultyAndSemesterId(Integer facultyId, Integer semesterId) {
        List<Student> studentList = studentRepo.findByFacultyAndSemesterId(facultyId, semesterId);
        return studentList.stream()
                .map(student -> {
                    return new StudentDto(
                            student.getId(),student.getName(),student.getSemester().getId(), student.getSemester().getName()
                    );
                }).collect(Collectors.toList());

    }
}
