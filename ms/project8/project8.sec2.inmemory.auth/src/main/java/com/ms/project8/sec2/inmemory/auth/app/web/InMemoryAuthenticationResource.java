package com.ms.project8.sec2.inmemory.auth.app.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inmemusers")
public class InMemoryAuthenticationResource {

    @GetMapping
    public String secMessage() {
        return "<H1> This is security message with in memory authentication setup.";
    }
}
