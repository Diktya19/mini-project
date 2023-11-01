package com.bootcamp.mvc01.controller;

import com.bootcamp.mvc01.dto.TokoDto;
import com.bootcamp.mvc01.entity.TokoEntity;
import com.bootcamp.mvc01.service.TokoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/toko")
public class TokoController {
    private final TokoService service;

    public TokoController(TokoService service) {
        this.service = service;
    }


    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("toko/index");

        String judul = "List Toko";
        view.addObject("dataJudul", judul);

        List<TokoEntity> dataToko = this.service.getAll();
        view.addObject("listToko", dataToko);

        int jumlahData = dataToko.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("toko/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute TokoDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/toko");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        TokoEntity entity = this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/toko");
        }
        ModelAndView view = new ModelAndView("toko/edit");
        view.addObject("toko", entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute TokoDto request) {
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/toko");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute TokoDto request) {
        TokoEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/toko");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/toko");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id) {
        TokoEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/toko");
        }
        ModelAndView view = new ModelAndView("toko/detail");
        view.addObject("toko", product);
        return view;
    }
}
