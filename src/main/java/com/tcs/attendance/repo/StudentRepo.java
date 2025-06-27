package com.tcs.attendance.repo;

import com.tcs.attendance.entity.MasterYear;
import com.tcs.attendance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from student where faculty_id= ?1 and semester_id= ?2"
    )
    List<Student> findByFacultyAndSemesterId(Integer facultyId, Integer semesterId);
}
