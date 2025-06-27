package com.tcs.attendance.repo;

import com.tcs.attendance.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SemesterRepo extends JpaRepository<Semester,Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from semester where master_year_id= ?1"
    )
    List<Semester> findSemesterByMasterYearId(Integer masterYearId);
}
