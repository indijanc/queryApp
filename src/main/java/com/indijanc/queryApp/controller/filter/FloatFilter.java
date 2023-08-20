package com.indijanc.queryApp.controller.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FloatFilter extends FieldFilter {
    private Double gte;
    private Double lt;
}
