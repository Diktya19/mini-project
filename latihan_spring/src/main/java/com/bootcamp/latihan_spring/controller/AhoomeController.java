package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AhoomeController {

    @GetMapping("/ping")
    public ResponseEntity<Object> ping(){
        Response result = new Response(200,"Success","Ping");
        return ResponseEntity.ok()
                .body(result);
    }
}
