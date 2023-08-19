package com.indijanc.queryApp.controller.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntFilter extends FieldFilter {
    private Integer gte;
    private Integer lt;
}
