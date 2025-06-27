package com.tcs.attendance.repo;

import com.tcs.attendance.entity.Faculty;
import com.tcs.attendance.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty,Integer> {
}
