package com.spring.bean;


import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Users {
    private Integer id;
    private String name;
    private String pwd;
    private Date createTime;


    @Setter //转变time的时间格式
    public void setUpdateTime(String createTime) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date df = format1.parse(createTime);
            this.createTime = df;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}