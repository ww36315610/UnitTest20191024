package com.spring.controller;

import com.spring.bean.MyCase;
import com.spring.bean.SqlMyCase;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mycase")
@Api(tags = "Case相关接口", description = "提供Case相关的 Rest API")
public class CaseController {

    /**
     * 常用CURD操作大致使用以下三个方法:
     * 1.execute方法，用于直接执行SQL语句
     * 2.update方法，用户新增修改删除操作
     * 3.query方法，用于查询方法
     */
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    SqlMyCase sqlMyCase;

    @GetMapping("/createTable")
    public String createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS `mycase` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `case_name` varchar(255) DEFAULT NULL,\n" +
                "  `case_url` varchar(255) DEFAULT NULL,\n" +
                "  `case_body` varchar(255) DEFAULT NULL,\n" +
                "  `status` int(11) DEFAULT NULL DEFAULT 0,\n" +
                "  `sortNO`  int(11) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;\n" +
                "\n";
        jdbcTemplate.execute(sql);
        return "创建mycase表成功";
    }

    @PostMapping("/add")
    public String addCase(@RequestBody MyCase cases) {
//        INSERT into mycase(case_name,case_url,case_body,status,sortNo) values('login','http://localhost:8080/login','{"param":{"lable_name":"want01"}}',0,1);
        String sql = "INSERT into mycase(case_name,case_url,case_body,status,sortNo) values(?,?,?,?,?)";
        int row = jdbcTemplate.update(sql, cases.getCaseName(), cases.getCaseUrl(), cases.getCaseBody(), cases.getStatus(), cases.getSortNo());
        System.out.println(sql);
        System.out.println(cases);
        return "SUCESS";
    }

    /**
     * 【批量】新增数据
     * application/json
     *
     * @param caseMysqlList
     * @return
     */
    @PostMapping("/addList")
    public String addCaseList(@RequestBody List<Map<String, Object>> caseMysqlList) {
        String sql = "INSERT into mycase(case_name,case_url,case_body,status,sortNo) values(?,?,?,?,?)";
        List<Object[]> list = new ArrayList<>();
        caseMysqlList.forEach(m -> {
            Object args[] = {m.get("caseName"), m.get("caseUrl"), m.get("caseBody"), m.get("status"), m.get("sortNO")};
            list.add(args);
        });
        jdbcTemplate.batchUpdate(sql, list);
        return "SUCCESS";
    }

    @ResponseBody
    @PostMapping("/delete")
    public String deleteCase(@RequestParam(value = "id", required = false) Integer id) {
        String sql = "DELETE from mycase  where id = ?";
        jdbcTemplate.update(sql, id);
        return "SUCCESS";
    }

    @ResponseBody
    @PostMapping("/update")
    public String update(@RequestParam String caseName, @RequestParam Integer id) {
        String sql = "UPDATE mycase set case_name = ? where id = ?";
        jdbcTemplate.update(sql, caseName, id);
        return "SUCCESS";
    }

    //从配置文件读取sql
    @GetMapping("/get")
    public List<MyCase> get(@RequestParam String caseName) {
        System.out.println(caseName);
//        String sql = "SELECT * from mycase where  case_name = ?";
        String sql  =sqlMyCase.get;
        System.out.println("=======]]]]"+sql);
        List<MyCase> mycaseList = jdbcTemplate.query(sql, new Object[]{caseName}, new BeanPropertyRowMapper(MyCase.class));
        return mycaseList;
    }


    @GetMapping("/getAll")
    public List<Map<String, Object>> getAll(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam(value = "caseUrl", defaultValue = "") String caseUrl) {
        String sql = "SELECT * from mycase where  case_url = ? and id > ? limit ?";
        List<Map<String, Object>> mycaseList = jdbcTemplate.queryForList(sql,caseUrl, pageNum, pageSize);
        System.out.println("========="+sql);
        return mycaseList;
    }
}
