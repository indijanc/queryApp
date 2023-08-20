package com.indijanc.queryApp.controller.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooleanFilter extends FieldFilter {
    private Boolean equals;
}
