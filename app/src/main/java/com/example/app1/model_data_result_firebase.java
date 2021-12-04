package com.example.app1;

public class model_data_result_firebase {
    String Subject;
    String marks;
    String level;
    String skip;

    public model_data_result_firebase(){

    }

    public model_data_result_firebase(String Subject, String marks, String level, String skip) {
        this.Subject = Subject;
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
        return Subject;
    }

    public void setSubject(String subject) {
        this.Subject = subject;
    }
}
