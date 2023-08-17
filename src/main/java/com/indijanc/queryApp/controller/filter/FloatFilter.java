package com.indijanc.queryApp.controller.filter;

public class FloatFilter extends FieldFilter {
    private Float gte;
    private Float lt;

    public Float getGte() {
        return gte;
    }

    public Float getLt() {
        return lt;
    }

    public void setGte(Float gte) {
        this.gte = gte;
    }

    public void setLt(Float lt) {
        this.lt = lt;
    }
}
