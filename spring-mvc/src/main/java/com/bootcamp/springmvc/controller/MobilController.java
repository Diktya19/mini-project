package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.MobilEntity;
import com.bootcamp.springmvc.model.MobilDto;
import com.bootcamp.springmvc.service.MobilService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mobil")
public class MobilController {

    private final MobilService service;

    public MobilController(MobilService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("mobil/index");
        String judul = "List Data Mobil";
        view.addObject("dataJudul", judul);

        List<MobilEntity> dataMobil = this.service.getAll();
        view.addObject("listMobil", dataMobil);

        int jumlahData = dataMobil.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("mobil/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MobilDto reqeust){
        this.service.save(reqeust);
        return new ModelAndView("redirect:/mobil");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        MobilEntity entity = this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/mobil");
        }
        ModelAndView view = new ModelAndView("mobil/edit");
        view.addObject("mobil", entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MobilDto request){
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/mobil");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute MobilDto request){
        MobilEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/mobil");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/mobil");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        MobilEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/mobil");
        }
        ModelAndView view = new ModelAndView("mobil/detail");
        view.addObject("mobil", product);
        return view;
    }
}
