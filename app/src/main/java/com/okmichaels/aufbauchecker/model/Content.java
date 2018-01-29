package com.okmichaels.aufbauchecker.model;


import java.util.ArrayList;

public class Content {
    //generic attrs
    private String title;

    //success attrs
    private String candidate_number;
    private String candidate_name;
    private String exam_type;
    private String center;
    private ArrayList<Grade> grades;

    //failure attrs
    private String error_message;
    private String error_title;

    public String getTitle() {
        return this.title;
    }

    public String getCandidate_number() {
        return candidate_number;
    }

    public String getCandidate_name() {
        return candidate_name;
    }

    public String getExam_type() {
        return exam_type;
    }

    public String getCenter() {
        return center;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grd) {
        this.grades = grd;
    }

    public String getError_message() {
        return error_message;
    }

    public String getError_title() {
        return error_title;
    }
}
