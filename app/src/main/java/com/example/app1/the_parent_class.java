package com.example.app1;

class the_parent_class {
    static String url;
    static String category;
    static boolean flag=false;
    static String subject;
    static String test_code1="";
    static String test_code2="";
    static String level="";

    //---------------------------setting the question limit and question difficulty
    public void setCategory(String category) {
        the_parent_class.category = category;
        url=url+category;
    }

    // ------------------------------------setting url for fetching question from the API

    public void setUrl(String url) {
        the_parent_class.url = url;
    }

    public String getUrl() {
        return url;
    }

    // ----------------------------------------flag to check weather timer is on or off

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        the_parent_class.flag = flag;
    }

    //------------------------------------ correct answer by the user during quiz


    //--------------------selection of subject by user

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        the_parent_class.subject = subject;
    }

    //-------------------------test code generation

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

    //----------------------------------getter setter for question level


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        the_parent_class.level = level;
    }
}
