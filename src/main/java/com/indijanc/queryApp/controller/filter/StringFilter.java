package com.indijanc.queryApp.controller.filter;

public class StringFilter extends FieldFilter {
    private String contains;
    private String equals;

    public String getContains() {
        return contains;
    }

    public String getEquals() {
        return equals;
    }

    public void setContains(String contains) throws Exception {
        this.contains = contains;
    }

    public void setEquals(String equals) throws Exception {
        this.equals = equals;
    }
}
