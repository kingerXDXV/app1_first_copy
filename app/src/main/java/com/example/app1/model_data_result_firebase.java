package com.example.app1;

public class model_data_result_firebase {
    String subject;
    String marks;
    String level;
    String skip;

    public model_data_result_firebase(){

    }

    public model_data_result_firebase(String subject, String marks, String level, String skip) {
        this.subject = subject;
        this.marks = marks;
        this.level = level;
        this.skip = skip;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
