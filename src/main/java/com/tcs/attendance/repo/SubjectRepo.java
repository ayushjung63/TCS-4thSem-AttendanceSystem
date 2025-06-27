package com.tcs.attendance.repo;

import com.tcs.attendance.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from subject where semester_id=?1"
    )
    List<Subject> findBySemesterId(Integer semesterId);


    // @Query()
    // method
}
