package com.indijanc.queryApp.controller.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FloatFilter extends FieldFilter {
    private Float gte;
    private Float lt;
}
