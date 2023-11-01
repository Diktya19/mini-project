package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.LaptopEntity;
import com.bootcamp.springmvc.model.LaptopDto;
import com.bootcamp.springmvc.service.LaptopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/laptop")
public class LaptopController {

    private final LaptopService service;

    public LaptopController(LaptopService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("laptop/index");
        String judul = "List Laptop";
        view.addObject("dataJudul", judul);

        List<LaptopEntity> dataLaptop = this.service.getAll();
        view.addObject("listLaptop", dataLaptop);

        int jumlahData = dataLaptop.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("laptop/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute LaptopDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/laptop");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        LaptopEntity entity = this.service.getById(id);
        if (entity == null) {
            return new ModelAndView("redirect:/laptop");
        }
        ModelAndView view = new ModelAndView("laptop/edit");
        view.addObject("laptop", entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute LaptopDto request){
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/laptop");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute LaptopDto request){
        LaptopEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/laptop");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/laptop");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        LaptopEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/laptop");
        }
        ModelAndView view = new ModelAndView("laptop/detail");
        view.addObject("laptop", product);
        return view;
    }
}
