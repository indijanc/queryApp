package com.indijanc.queryApp.controller.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FloatFilter extends FieldFilter {
    private Double gte;
    private Double lt;
}
