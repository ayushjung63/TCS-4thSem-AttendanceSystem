package com.tcs.attendance.service;

import com.tcs.attendance.dto.SemesterDto;
import com.tcs.attendance.entity.MasterYear;
import com.tcs.attendance.entity.Semester;
import com.tcs.attendance.repo.MasterYearRepo;
import com.tcs.attendance.repo.SemesterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private SemesterRepo semesterRepo;

    @Autowired
    private MasterYearRepo masterYearRepo;

    @Override
    public void save(SemesterDto semDto) {
        Semester sem;
        if (semDto.getId()!=null){
            sem=this.findById(semDto.getId());
        }else {
            sem = new Semester();
        }
        sem.setName(semDto.getName());
        Optional<MasterYear> optionalMasterYear = masterYearRepo.findById(semDto.getMasterYearId());
        if (optionalMasterYear.isPresent()) {
            sem.setMasterYear(optionalMasterYear.get());
        }else{
            throw new RuntimeException("Master Year Not Found with id: "+ semDto.getMasterYearId());
        }
        semesterRepo.save(sem);
    }

    @Override
    public List<SemesterDto> findAll() {
        List<Semester> semesterList = semesterRepo.findAll();
        List<SemesterDto> dtoList = new ArrayList<>();
        for (Semester sem : semesterList) {
            SemesterDto semesterDto = new SemesterDto();
            semesterDto.setId(sem.getId());
            semesterDto.setName(sem.getName());
            semesterDto.setMasterYearId(sem.getMasterYear().getId());
            semesterDto.setMasterYearName(sem.getMasterYear().getName());
            dtoList.add(semesterDto);
        }
        return dtoList;
    }

    @Override
    public List<Semester> findByMasterYear(Long masterYearId) {
        return List.of();
    }

    @Override
    public Semester findById(int id) {
        Optional<Semester> semesterOptional = semesterRepo.findById(id);
        if (semesterOptional.isPresent()) {
            return semesterOptional.get();
        }
        throw new RuntimeException("Semester not found with id: " + id);
    }

    @Override
    public void delete(Integer id) {

    }
}
