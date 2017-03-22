package com.janita.aop.two.controller;

import com.janita.aop.two.annotation.ExecTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-22 08:50
 */
@RestController
@RequestMapping("/aop")
public class AopTwoController {

    @ExecTime
    @RequestMapping(value = "/two")
    public String aop(String name){
        System.out.println("*******执行了controller中的方法");
        return "Hello "+name;
    }
}
