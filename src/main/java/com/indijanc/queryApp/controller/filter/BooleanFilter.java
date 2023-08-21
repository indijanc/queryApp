package com.indijanc.queryApp.controller.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BooleanFilter extends FieldFilter {
    private Boolean equals;
}
