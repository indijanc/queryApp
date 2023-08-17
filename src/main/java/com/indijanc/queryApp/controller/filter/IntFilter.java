package com.indijanc.queryApp.controller.filter;

public class IntFilter extends FieldFilter {
    private Integer gte;
    private Integer lt;

    public Integer getGte() {
        return gte;
    }

    public Integer getLt() {
        return lt;
    }

    public void setGte(Integer gte) {
        this.gte = gte;
    }

    public void setLt(Integer lt) {
        this.lt = lt;
    }
}
