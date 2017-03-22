package com.janita.aop.one.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-22 08:50
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @RequestMapping(value = "/a")
    public String aop(String name){
        System.out.println("*******执行了controller中的方法");
        return "Hello "+name;
    }
}
