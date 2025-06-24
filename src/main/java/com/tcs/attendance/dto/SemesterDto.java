package com.tcs.attendance.dto;

public class SemesterDto {
    private Integer id;
    private String name;
    private Integer masterYearId;
    private String masterYearName;

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

    public Integer getMasterYearId() {
        return masterYearId;
    }

    public void setMasterYearId(Integer masterYearId) {
        this.masterYearId = masterYearId;
    }

    public String getMasterYearName() {
        return masterYearName;
    }

    public void setMasterYearName(String masterYearName) {
        this.masterYearName = masterYearName;
    }
}
