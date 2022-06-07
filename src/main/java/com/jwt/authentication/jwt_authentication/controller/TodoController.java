package com.jwt.authentication.jwt_authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class TodoController {

    public TodoController (){

    }

    @GetMapping()
    public ResponseEntity<String> getTodo(){
        return ResponseEntity.ok().body("will see Todo");
    }
}
