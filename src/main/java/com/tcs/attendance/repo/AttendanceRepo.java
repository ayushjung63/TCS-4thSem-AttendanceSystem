package com.tcs.attendance.repo;

import com.tcs.attendance.entity.Attendance;
import com.tcs.attendance.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance,Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from attendance where subject_id=?1 and date=?2;"
    )
    List<Attendance> findBySubjectAndDate(Integer subjectId, LocalDate date);


    @Query(
            nativeQuery = true,
            value = "select distinct s.name from attendance a\n" +
                    "                           inner join subject s on s.id=a.subject_id\n" +
                    "                           where a.date= ?1"
    )
    List<String> findAllAttendanceSubjectByDate(LocalDate date);

}
