package com.tcs.attendance.repo;

import com.tcs.attendance.entity.Attendance;
import com.tcs.attendance.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance,Integer> {
}
