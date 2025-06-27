package com.tcs.attendance.controller;

import com.tcs.attendance.dto.SemesterDto;
import com.tcs.attendance.entity.Semester;
import com.tcs.attendance.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semester")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody SemesterDto semester) {
        semesterService.save(semester);
        return "Semester saved successfully";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SemesterDto> list() {
        List<SemesterDto> semDtoList = semesterService.findAll();
        return semDtoList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Semester get(@PathVariable Integer id) {
        Semester sem = semesterService.findById(id);
        return sem;
    }

    @RequestMapping(value = "/master-year-id/{masterYearId}", method = RequestMethod.GET)
    public  List<SemesterDto> getByMasterYearId(@PathVariable Integer masterYearId) {
        List<SemesterDto> semList = semesterService.findByMasterYearId(masterYearId);
        return semList;
    }



}
