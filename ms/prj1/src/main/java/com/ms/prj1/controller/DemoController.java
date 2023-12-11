package com.ms.prj1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("/welcome")
    public String sayWelcome () {
        return "<H1>Welcome</H1>";
    }
}
