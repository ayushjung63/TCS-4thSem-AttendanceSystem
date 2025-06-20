package com.tcs.attendance.service;

import com.tcs.attendance.entity.MasterYear;
import com.tcs.attendance.repo.MasterYearRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasterYearServiceImpl implements MasterYearService {

    @Autowired
    private MasterYearRepo masterYearRepo;

    @Override
    public void save(MasterYear masterYear) {
        MasterYear entity;
        // save
        // if not id present in req, this is save case
        if (masterYear.getId()== null){
            // create new empty object
            entity=new MasterYear();
        }else{
            // update case
            // if id is present in request, this is update case
            // fetch exisiting masterYear by id from database
            entity=this.findById(masterYear.getId());
        }
        entity.setName(masterYear.getName());
        masterYearRepo.save(masterYear);
    }

    @Override
    public List<MasterYear> findAll() {
        return masterYearRepo.findAll();
    }

    @Override
    public MasterYear findById(int id) {
        Optional<MasterYear> optionalMasterYear = masterYearRepo.findById(id);
        if (optionalMasterYear.isEmpty()){
            throw new RuntimeException("Master Year Not Found with id : "+ id);
        }
        return optionalMasterYear.get();
    }

    @Override
    public void delete(Integer id) {
        Optional<MasterYear> optionalMasterYear = masterYearRepo.findById(id);
        if (optionalMasterYear.isEmpty()){
            throw new RuntimeException("Master Year Not Found with id : "+ id);
        }
        masterYearRepo.deleteById(id);
    }
}
