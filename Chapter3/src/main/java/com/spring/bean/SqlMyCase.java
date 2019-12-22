package com.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "sql.properties")
public class SqlMyCase {

    @Value("${mycase.add}")
   public String add;

    @Value("${mycase.addList}")
    public String addList;

    @Value("${mycase.delete}")
    public String delete;

    @Value("${mycase.update}")
    public String update;

    @Value("${mycase.get}")
    public String get;

    @Value("${mycase.getAll}")
    public String getAll;

}
