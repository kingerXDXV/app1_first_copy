package com.example.app1;

class the_parent_class {
    static String url;
    static String category;
    static boolean flag=false;
    static int answer_correct=0;
    static String subject;
    static String test_code1="";
    static String test_code2="";

    // category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        the_parent_class.category = category;
        url=url+category;
    }

    // url

    public void setUrl(String url) {
        the_parent_class.url = url;
    }

    public String getUrl() {
        return url;
    }

    // flag

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        the_parent_class.flag = flag;
    }

    // correct answer


    public int getAnswer_correct() {
        return answer_correct;
    }

    public void setAnswer_correct(int answer_correct) {
        the_parent_class.answer_correct = answer_correct;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        the_parent_class.subject = subject;
    }

    public String getTest_code1() {
        return test_code1;
    }

    public void setTest_code1(String test_code1) {
        the_parent_class.test_code1 = test_code1;
    }

    public String getTest_code2() {
        return test_code2;
    }

    public void setTest_code2(String test_code2) {
        the_parent_class.test_code2 = test_code2;
    }
}
