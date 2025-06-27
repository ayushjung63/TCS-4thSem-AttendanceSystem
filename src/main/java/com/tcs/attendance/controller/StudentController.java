package com.tcs.attendance.controller;

import com.tcs.attendance.dto.StudentDto;
import com.tcs.attendance.dto.SubjectDto;
import com.tcs.attendance.service.StudentService;
import com.tcs.attendance.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/list/faculty-id/{facultyId}/semester-id/{semesterId}", method = RequestMethod.GET)
    public  List<StudentDto> getStudentByFacultyAndSemesterId(@PathVariable Integer facultyId,@PathVariable Integer semesterId) {
        List<StudentDto> studentList = studentService.findStudentByFacultyAndSemesterId(facultyId,semesterId);
        return studentList;
    }

}
