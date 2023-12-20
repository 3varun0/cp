package com.ms.project10.sec.authDB.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dbauth")
public class SecurityAuthDBResource {

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        String msg = "<H1>this is security auth with db hello</H1>";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/adminpage")
    public ResponseEntity<String> adminPage() {
        String msg = "<H1>this is security auth with db adminpage</H1>";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/userpage")
    public ResponseEntity<String> userPage() {
        String msg = "<H1>this is security auth with db userpage</H1>";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
