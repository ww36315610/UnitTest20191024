package com.spring.services;

import com.spring.bean.Users;

import java.util.List;
import java.util.Map;

public interface UserServices {

    /**
     * 创建表
     * @return
     */
    public String createTable();


    /**
     * 新增一个用户
     *
     * @param name
     * @param pwd
     */
    String add(String name, String pwd, String createTime);


    /**
     * 新增用户[批量]
     */
    String addList(List<Map<String, Object>> userList);


    /**
     * 根据name删除一个用户高
     *
     * @param name
     */
    String delete(String name);


    /**
     * 修改一个用户
     * @param users
     * @return
     */
    String update(Users users);


    /**
     * 获取用户总量
     */
    List<Users> getAll();

    /**
     * 获取单个用户
     * @param id
     * @return
     */
    Users get(Integer id);
}
