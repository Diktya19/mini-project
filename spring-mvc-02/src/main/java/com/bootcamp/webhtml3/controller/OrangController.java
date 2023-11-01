package com.bootcamp.webhtml3.controller;

import com.bootcamp.webhtml3.dto.OrangDto;
import com.bootcamp.webhtml3.entity.OrangEntity;
import com.bootcamp.webhtml3.service.OrangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orang")
public class OrangController {
    private final OrangService service;

    public OrangController(OrangService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("orang/index");
        String judul = "List Orang";
        view.addObject("dataJudul", judul);

        List<OrangEntity> dataOrang = this.service.getAll();
        view.addObject("listOrang", dataOrang);

        int jumlahData = dataOrang.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("orang/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute OrangDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/orang");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        OrangEntity entity =this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/orang");
        }
        ModelAndView view = new ModelAndView("orang/edit");
        view.addObject("orang", entity);
        return view;
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(@ModelAttribute OrangDto request) {
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/orang");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute OrangDto request) {
        OrangEntity result = this.service.getById(request.getId());
        if (result == null) {
            return new ModelAndView("redirect:/orang");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redierct:/orang");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id) {
        OrangEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/orang");
        }
        ModelAndView view = new ModelAndView("orang/detail");
        view.addObject("orang", product);
        return view;
    }
}
