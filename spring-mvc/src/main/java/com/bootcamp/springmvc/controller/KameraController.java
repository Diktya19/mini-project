package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.service.KameraService;
import com.bootcamp.springmvc.entity.KameraEntity;
import com.bootcamp.springmvc.model.KameraDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/kamera")
public class KameraController {

    private final KameraService service;

    public KameraController(KameraService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("kamera/index");

        String judul = "Eusi Datana Kamera";
        view.addObject("dataJudul", judul);

        List<KameraEntity> dataKamera = this.service.getAll();
        view.addObject("listKamera", dataKamera);

        int jumlahData = dataKamera.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("kamera/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute KameraDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/kamera");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        KameraEntity entity = this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:kamera");
        }
        ModelAndView view = new ModelAndView("kamera/edit");
        view.addObject("kamera", entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute KameraDto request){
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/kamera");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute KameraDto request){
        KameraEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/kamera");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/kamera");
    }

    @GetMapping("/detail/{id}")
    public  ModelAndView detail(@PathVariable("id") Integer id){
        KameraEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/kamera");
        }
        ModelAndView view = new ModelAndView("kamera/detail");
        view.addObject("kamera", product);
        return view;
    }
}
