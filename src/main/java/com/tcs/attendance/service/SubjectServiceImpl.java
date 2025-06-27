package com.tcs.attendance.service;

import com.tcs.attendance.dto.SubjectDto;
import com.tcs.attendance.entity.Subject;
import com.tcs.attendance.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;


    @Override
    public List<SubjectDto> getSubjectBySemesterId(Integer semesterId) {
        List<Subject> subjects = subjectRepo.findBySemesterId(semesterId);
        List<SubjectDto> subjectDtoList = subjects.stream()
                .map(subject -> {
                    return new SubjectDto(
                            subject.getId(), subject.getName(), subject.getSemester().getId(),
                            subject.getSemester().getName(), subject.getCode()
                    );
                        }).collect(Collectors.toList());
        return subjectDtoList;
    }
}
