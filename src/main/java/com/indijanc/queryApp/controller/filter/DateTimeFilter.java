package com.indijanc.queryApp.controller.filter;

import com.indijanc.queryApp.utility.ParseUtil;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DateTimeFilter extends FieldFilter {
    private LocalDateTime gte;
    private LocalDateTime lt;

    public void setGte(String gte) {
        this.gte = ParseUtil.parseDateTime(gte);
    }

    public void setLt(String lt) {
        this.lt = ParseUtil.parseDateTime(lt);
    }
}
