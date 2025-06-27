package com.tcs.attendance.controller;

import com.tcs.attendance.dto.SemesterDto;
import com.tcs.attendance.dto.SubjectDto;
import com.tcs.attendance.entity.Semester;
import com.tcs.attendance.service.SemesterService;
import com.tcs.attendance.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/semester-id/{semesterId}", method = RequestMethod.GET)
    public  List<SubjectDto> getBySemesterId(@PathVariable Integer semesterId) {
        List<SubjectDto> subjectList = subjectService.getSubjectBySemesterId(semesterId);
        return subjectList;
    }

}
