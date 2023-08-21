package com.indijanc.queryApp.controller.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StringFilter extends FieldFilter {
    private String contains;
    private String equals;
}
