package com.tcs.attendance.service;

import com.tcs.attendance.dto.AttendanceDto;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    void bulkAddAttendance(AttendanceDto dto);
    AttendanceDto getAttendanceBySubjectAndDate(Integer subjectId, LocalDate date);

    List<String> getAttendanceSubjectByDate(LocalDate date);
}
