package com.tcs.attendance.dto;

public class SubjectDto {
    private Integer id;
    private String name;
    private String code;
    private Integer semesterId;
    private String semesterName;

    public SubjectDto(){}

    public SubjectDto(Integer id, String name, Integer semesterId, String semesterName,String code) {
        this.id = id;
        this.name = name;
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.code = code;
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

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
