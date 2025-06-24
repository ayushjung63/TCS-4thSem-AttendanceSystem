package com.tcs.attendance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "master_year_id")
    private MasterYear masterYear;

    public Semester(){}

    public Semester(String name, MasterYear masterYear) {
        this.name = name;
        this.masterYear = masterYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MasterYear getMasterYear() {
        return masterYear;
    }

    public void setMasterYear(MasterYear masterYear) {
        this.masterYear = masterYear;
    }
}
