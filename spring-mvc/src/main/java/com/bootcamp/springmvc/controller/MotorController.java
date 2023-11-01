package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.MotorEntity;
import com.bootcamp.springmvc.model.MotorDto;
import com.bootcamp.springmvc.service.MotorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/motor")
public class MotorController {

    private final MotorService service;

    public MotorController(MotorService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("motor/index");
        String judul = "List Motor";
        view.addObject("dataJudul", judul);

        List<MotorEntity> dataMotor = this.service.getAll();
        view.addObject("listMotor", dataMotor);

        int jumlahData = dataMotor.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("motor/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MotorDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/motor");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        MotorEntity entity = this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/motor");
        }
        ModelAndView view = new ModelAndView("motor/edit");
        view.addObject("motor", entity);
        return view;
    }

    @PostMapping("/update/")
    public ModelAndView update(@ModelAttribute MotorDto request){
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/motor");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute MotorDto request){
        MotorEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/motor");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/motor");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        MotorEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/motor");
        }
        ModelAndView view = new ModelAndView("motor/detail");
        view.addObject("motor", product);
        return view;
    }
}
