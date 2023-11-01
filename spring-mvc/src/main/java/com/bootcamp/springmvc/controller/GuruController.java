package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.GuruEntity;
import com.bootcamp.springmvc.model.GuruDto;
import com.bootcamp.springmvc.service.GuruService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/guru")
public class GuruController {

    private final GuruService service;

    public GuruController(GuruService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("guru/index");
        String judul = "List Guru";
        view.addObject("dataJudul", judul);

        List<GuruEntity> dataGuru = this.service.getAll();
        view.addObject("listGuru",dataGuru);

        int jumlahData = dataGuru.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("guru/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute GuruDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/guru");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        GuruEntity entity = this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/guru");
        }
        ModelAndView view = new ModelAndView("guru/edit");
        view.addObject("guru", entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute GuruDto request){
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/guru");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute GuruDto request){
        GuruEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/guru");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/guru");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        GuruEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/guru");
        }
        ModelAndView view = new ModelAndView("guru/detail");
        view.addObject("guru", product);
        return view;
    }
}
