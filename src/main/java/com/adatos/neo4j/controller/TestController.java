package com.adatos.neo4j.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "funsiona";
    }
}
