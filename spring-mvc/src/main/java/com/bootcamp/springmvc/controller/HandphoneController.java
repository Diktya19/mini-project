package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.HandphoneEntity;
import com.bootcamp.springmvc.model.HandphoneDto;
import com.bootcamp.springmvc.service.HandphoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/handphone")
public class HandphoneController {

    private final HandphoneService service;

    public HandphoneController(HandphoneService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("handphone/index");

        String judul = "List Product";
        view.addObject("dataJudul", judul);
        // get data, dari service, service ke repo, repo ke database
        List<HandphoneEntity> dataHandphone = this.service.getAll();
        // kirim data ke view
        view.addObject("listHandphone", dataHandphone);
        // menghitung jumlah data
        int jumlahData = dataHandphone.size();
        // kirim data ke view
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("handphone/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute HandphoneDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/handphone");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        HandphoneEntity entity = this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/handphone");
        }
        ModelAndView view = new ModelAndView("handphone/edit");
        view.addObject("handphone", entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute HandphoneDto request){
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/handphone");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute HandphoneDto request){
        HandphoneEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/handphone");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/handphone");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        HandphoneEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/handphone");
        }
        ModelAndView view = new ModelAndView("handphone/detail");
        view.addObject("handphone", product);
        return view;
    }

}
