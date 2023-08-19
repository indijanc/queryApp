package com.indijanc.queryApp.controller.filter;

import com.indijanc.queryApp.utility.ParseUtil;

import java.time.LocalDateTime;

public class DateTimeFilter extends FieldFilter {
    private LocalDateTime gte;
    private LocalDateTime lt;

    public LocalDateTime getGte() {
        return gte;
    }

    public LocalDateTime getLt() {
        return lt;
    }

    public void setGte(String gte) {
        this.gte = ParseUtil.parseDateTime(gte);
    }

    public void setLt(String lt) {
        this.lt = ParseUtil.parseDateTime(lt);
    }
}
