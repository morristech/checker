package com.okmichaels.aufbauchecker.model;

public class Grade {
    String subject;
    String score;

    public Grade(String sub, String scr) {
        this.subject = sub;
        this.score = scr;
    }

    public void setSubject(String sub) {
        this.subject = sub;
    }

    public void setScore(String scr) {
        this.score = scr;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getScore() {
        return this.score;
    }
}
