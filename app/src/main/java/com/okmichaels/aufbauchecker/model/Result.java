package com.okmichaels.aufbauchecker.model;


import java.util.ArrayList;

public class Result {
    String candidate_number;
    String candidate_name;
    String exam_type;
    String exam_center;
    ArrayList<Grade> grades;

    public Result(String number, String name, String type, String center,
                  ArrayList<Grade> grds) {
        this.candidate_name = name;
        this.candidate_number = number;
        this.exam_type = type;
        this.exam_center = center;
        this.grades = grds;
    }

    public String getCandidate_number() {
        return candidate_number;
    }

    public void setCandidate_number(String candidate_number) {
        this.candidate_number = candidate_number;
    }

    public String getCandidate_name() {
        return candidate_name;
    }

    public void setCandidate_name(String candidate_name) {
        this.candidate_name = candidate_name;
    }

    public String getExam_type() {
        return exam_type;
    }

    public void setExam_type(String exam_type) {
        this.exam_type = exam_type;
    }

    public String getExam_center() {
        return exam_center;
    }

    public void setExam_center(String exam_center) {
        this.exam_center = exam_center;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }
}
