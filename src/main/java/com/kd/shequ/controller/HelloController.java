package com.kd.shequ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * hello
 *
 * @author sunny
 * @create 2018/6/4 17:13
 **/
@Controller
//@RestController 这是response 会不走jsp页面，转变成字符串返回
public class HelloController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
