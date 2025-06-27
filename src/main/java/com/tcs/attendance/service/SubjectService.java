package com.tcs.attendance.service;

import com.tcs.attendance.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    public List<SubjectDto> getSubjectBySemesterId(Integer semesterId);
}
