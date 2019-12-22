package com.spring.controller;

import com.spring.bean.Order;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class GetPostParamController {


    @GetMapping(value = "/getUserParam")
    public String getUserParam(@RequestParam(value = "id") Integer id) {
        return "getUserParam";
    }

    /**
     * Post请求的参数可以通过@PathVariable和@RequestParam获取
     *
     * @param name 必填
     * @param pwd  选填，默认值为123123
     * @return
     */
    @PostMapping(value = "/postUserParam")
    public String postUserParam(@RequestParam(value = "name") String name,
                                @RequestParam(value = "pwd", required = false, defaultValue = "123123") String pwd) {
        return "postUserParam";
    }


    @PostMapping(value = "/postUserBody")
    public String postUserBody(@RequestBody Order order) {
        return "postUserBody";
    }


    /**
     * 上传方法
     */
    private final String PATH = "/Users/apple/Desktop";

    @PostMapping(value = "/file")
    public String file(MultipartFile file) throws IOException {
        File localFile = new File(PATH, "test.txt");
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getName();
    }
}