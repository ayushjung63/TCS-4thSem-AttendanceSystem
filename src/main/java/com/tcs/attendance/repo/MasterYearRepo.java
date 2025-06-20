package com.tcs.attendance.repo;

import com.tcs.attendance.entity.MasterYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterYearRepo extends JpaRepository<MasterYear,Integer> {
}
