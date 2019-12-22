package com.spring.bean;

import lombok.Data;

@Data
public class MyCase {
    private Integer id;
    private String caseName;
    private String caseUrl;
    private String caseBody;
    private Integer status;
    private Integer sortNo;
}

