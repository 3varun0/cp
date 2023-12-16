package com.ms.project7.sec1.app.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class DemoUnPwdSecurityResource {

    @GetMapping("/secured")
    public String securedResource () {
        return "<H1>THis is secured resource</H1>";
    }
}
