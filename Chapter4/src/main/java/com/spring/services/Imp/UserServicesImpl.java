package com.spring.services.Imp;

import com.spring.bean.SqlUsers;
import com.spring.bean.Users;
import com.spring.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
//@PropertySource(value = "classpath:sql.properties")
public class UserServicesImpl implements UserServices {
    public static void main(String[] args) {
        System.out.println("hello");
    }
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    SqlUsers sqlUsers;

    @Override
    public String createTable() {
        String sql = "CREATE TABLE `users` (\n" +
                "  `id` int(10) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(99) NOT NULL,\n" +
                "  `pwd` varchar(99) NOT NULL,\n" +
                "  `createTime` datetime(6) NOT NULL ON UPDATE CURRENT_TIMESTAMP(6),\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

        jdbcTemplate.execute(sql);
        return "创建表成功";
    }

    @Override
    public String add(String name, String pwd, String createTime) {
        String sql = "insert into users(name,pwd,createTime) values(?,?,?);";
        int row = jdbcTemplate.update(sql, name, pwd, createTime);
        return "success,共插入了【" + row + "】条记录！";
    }

    @Override
    public String addList(List<Map<String, Object>> userList) {
        String sql = "insert into users(name,pwd,createTime) values(?,?,?);";
        List<Object[]> list = new ArrayList<>();
        userList.forEach(m -> {
            Object args[] = {m.get("name"), m.get("pwd"), m.get("createTime")};
            list.add(args);
        });
        int[] row = jdbcTemplate.batchUpdate(sql, list);
        return "success,共插入了【" + row.length + "】条记录！";
    }

    @Override
    public String delete(String name) {
        String sql = "DELETE from users  where name = ?";
        int row = jdbcTemplate.update(sql, name);
        return "success,共删除了【" + row + "】条记录！";
    }

    @Override
    public String update(Users users) {
        String sql = "UPDATE users set pwd = ? where id = ?";
        int row = jdbcTemplate.update(sql, users.getPwd(), users.getId());
        return "success,共修改了【" + row + "】条记录！";
    }

    @Override
    public Users get(Integer id) {
//        String sql = "SELECT * from users where id = ?";
        String sql = sqlUsers.getGet();
        Users user = (Users) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Users.class));
        return user;
    }

    @Override
    public List<Users> getAll() {
        String sql = "SELECT * from users";
        List<Users> listUser = (List<Users>) jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(Users.class));
//        List<Users> listUser= (List<Users>)jdbcTemplate.queryForList(sql,new Object[]{}, Users.class);
        return listUser;
    }
}
