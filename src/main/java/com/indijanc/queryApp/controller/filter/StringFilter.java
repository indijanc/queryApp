package com.indijanc.queryApp.controller.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringFilter extends FieldFilter {
    private String contains;
    private String equals;
}
