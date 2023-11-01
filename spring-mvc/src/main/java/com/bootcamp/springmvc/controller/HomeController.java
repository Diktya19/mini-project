package com.bootcamp.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
// model itu untuk menampung data
// view untuk tampilan dalam bentuk web, dan web itu menggunakan dengan html, css, javascript
// patern cara pembuatan atau pola dan mengikuti aturan
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("layouts/main");
    }
}
