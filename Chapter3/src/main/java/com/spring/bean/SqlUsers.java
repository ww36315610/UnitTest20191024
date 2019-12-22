package com.spring.bean;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "sql.properties")
//执行前缀
@ConfigurationProperties(prefix = "users")
public class SqlUsers {
    public String add;

    public String addList;

    public String delete;

    public String update;

    public String get;

    public String getAll;
}
