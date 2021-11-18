package com.example.app1;

class the_parent_class {
    static String url;
    static String category;
    static boolean flag=false;

    // category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        the_parent_class.category = category;
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
}
