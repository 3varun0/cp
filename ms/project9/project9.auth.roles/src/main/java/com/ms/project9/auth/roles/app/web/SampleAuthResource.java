package com.ms.project9.auth.roles.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authroles")
public class SampleAuthResource {

    @GetMapping("hello")
    public ResponseEntity<String> sayHello() {
        String helloMsg = "<H1>security hello</H1>";
        return new ResponseEntity<>(helloMsg, HttpStatus.OK);
    }

    @GetMapping("adminpage")
    public ResponseEntity<String> adminPage() {
        String adminMsg = "<H1> security admin page</H1>";
        return new ResponseEntity<>(adminMsg, HttpStatus.OK);
    }

    @GetMapping("userpage")
    public ResponseEntity<String> userPage() {
        String userMsg = "<H1>security user page</H1>";
        return new ResponseEntity<>(userMsg, HttpStatus.OK);
    }
}
