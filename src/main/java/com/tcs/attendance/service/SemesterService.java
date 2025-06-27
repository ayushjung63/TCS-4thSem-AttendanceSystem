package com.tcs.attendance.service;

import com.tcs.attendance.dto.SemesterDto;
import com.tcs.attendance.entity.MasterYear;
import com.tcs.attendance.entity.Semester;

import java.util.List;

public interface SemesterService {
    void save(SemesterDto semester);
    List<SemesterDto> findAll();
    List<Semester> findByMasterYear(Long masterYearId);
    Semester findById(int id);

    void delete(Integer id);

    List<SemesterDto> findByMasterYearId(Integer masterYearId);
}
