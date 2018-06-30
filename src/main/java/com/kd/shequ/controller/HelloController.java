package com.kd.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kd.shequ.common.exception.BusinessException;
import com.kd.shequ.model.Address;
import com.kd.shequ.request.PageRequest;
import com.kd.shequ.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * hello
 *
 * @author sunny
 * @create 2018/6/4 17:13
 **/
@Slf4j
@Controller
//@RestController 这是response 会不走jsp页面，转变成字符串返回
public class HelloController {

    @Resource
    private AddressService addressService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/address")
    public String address(PageRequest page){
        List<Address> list = addressService.queryAllAdreeTest(page.getPageNum());
        log.info(JSONObject.toJSONString(list));
        return JSON.toJSONString(list);
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("hello method error.");
    }

    @RequestMapping("/hello2")
    public String hello2() throws BusinessException {
        throw new BusinessException("业务异常了.");
    }
}
