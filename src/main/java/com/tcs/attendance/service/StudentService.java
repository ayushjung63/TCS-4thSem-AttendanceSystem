package com.tcs.attendance.service;

import com.tcs.attendance.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findStudentByFacultyAndSemesterId(Integer facultyId, Integer semesterId);
}
