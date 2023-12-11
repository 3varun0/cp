package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo2")
public class Demo2Controller {
    @GetMapping("welcome2")
    public String sayWelcome() {
        return "<H2>Welcome 2 from Varun Kumar</H2>";
    }
}
