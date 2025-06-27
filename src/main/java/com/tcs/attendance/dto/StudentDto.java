package com.tcs.attendance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {
    private Integer id;
    private String name;
    private Integer subjectId;
    private Integer semesterId;
    private String subjectName ;
    private String semesterName ;

    private LocalDate date;

    public StudentDto(){}

    public StudentDto(Integer id, String name, Integer subjectId, Integer semesterId, String subjectName, String semesterName) {
        this.id = id;
        this.name = name;
        this.subjectId = subjectId;
        this.semesterId = semesterId;
        this.subjectName = subjectName;
        this.semesterName = semesterName;
    }

    public StudentDto(Integer id, String name, Integer semesterId, String semesterName) {
        this.id = id;
        this.name = name;
        this.semesterId = semesterId;
        this.semesterName = semesterName;
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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
