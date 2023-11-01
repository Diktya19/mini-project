package com.bootcamp.belajarspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/ping")
    public String getPing(){
        return "test-ping";
    }

    @GetMapping("/hitung")
    public Integer getHing(){
        return 100;
    }

    @GetMapping("/pecahan")
    public Double getPecahan(){
        return 50.5;
    }

    @GetMapping("/bool")
    public Boolean getBool(){
        return false;
    }

    @GetMapping("/cok")
    public String getChar(){
        return "Cok cok cok";
    }

    @GetMapping("/bool1")
    public Boolean getBool1(){
        return true;
    }

    @GetMapping("/short")
    public Short getShort(){
        return 1200;
    }

    @GetMapping("/name")
    public String getName(){
        return "Diktya";
    }

    @GetMapping("/nilai")
    public Byte getNilai(){
        return 100;
    }

    @GetMapping("/alamat")
    public String getAlamat(){
        return "Ciamis";
    }
}