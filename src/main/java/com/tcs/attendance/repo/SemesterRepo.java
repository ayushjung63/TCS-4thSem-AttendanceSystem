package com.tcs.attendance.repo;

import com.tcs.attendance.entity.MasterYear;
import com.tcs.attendance.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepo extends JpaRepository<Semester,Integer> {
}
