package com.tcs.attendance.controller;

import com.tcs.attendance.dto.AttendanceDto;
import com.tcs.attendance.entity.MasterYear;
import com.tcs.attendance.service.AttendanceService;
import com.tcs.attendance.service.MasterYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value = "/save-bulk", method = RequestMethod.POST)
    public String save(@RequestBody AttendanceDto dto) {
        attendanceService.bulkAddAttendance(dto);
        return "Attedance saved successfully for date : " + dto.getAttendanceDate();
    }

    @RequestMapping(value = "/subject-id/{subjectId}/{date}", method = RequestMethod.GET)
    public AttendanceDto fetchAttendanceBySubjectAndDate(@PathVariable Integer subjectId, @PathVariable LocalDate date) {
        AttendanceDto attendance = attendanceService.getAttendanceBySubjectAndDate(subjectId, date);
        return attendance;
    }

    @RequestMapping(value = "/list/subject/{date}", method = RequestMethod.GET)
    public List<String> fetchAttendanceSubjectByDate(@PathVariable LocalDate date) {
        List<String> subjectList = attendanceService.getAttendanceSubjectByDate(date);
        return subjectList;
    }

}
