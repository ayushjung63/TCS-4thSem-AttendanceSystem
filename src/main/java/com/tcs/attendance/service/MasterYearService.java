package com.tcs.attendance.service;

import com.tcs.attendance.entity.MasterYear;

import java.util.List;

public interface MasterYearService {
    void save(MasterYear masterYear);
    List<MasterYear> findAll();
    MasterYear findById(int id);
    void delete(Integer id);
}
