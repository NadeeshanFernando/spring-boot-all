package com.anton.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by nadeeshan_fdz
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String getTest(){
        return "Welcome Nadeeshan, Application Running...";
    }
}
