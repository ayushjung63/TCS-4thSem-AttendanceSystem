package com.tcs.attendance.controller;

import com.tcs.attendance.entity.MasterYear;
import com.tcs.attendance.service.MasterYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master-year")
public class MasterYearController {

    @Autowired
    private MasterYearService masterYearService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody MasterYear masterYear) {
        masterYearService.save(masterYear);
        return "Master year saved successfully";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<MasterYear> list() {
        return masterYearService.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        masterYearService.delete(id);
        return "Master Year deleted successfully";
    }


}
