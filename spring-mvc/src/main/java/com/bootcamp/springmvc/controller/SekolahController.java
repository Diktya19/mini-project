package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.SekolahEntity;
import com.bootcamp.springmvc.model.SekolahDto;
import com.bootcamp.springmvc.service.SekolahService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sekolah")
public class SekolahController {

    private final SekolahService service;

    public SekolahController(SekolahService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("sekolah/index");

        String judul = "Daftar Sekolah";
        view.addObject("dataJudul", judul);

        List<SekolahEntity> dataSekolah = this.service.getAll();
        view.addObject("listSekolah", dataSekolah);

        int jumlahData = dataSekolah.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("sekolah/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SekolahDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/sekolah");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        SekolahEntity entity = this.service.getBtId(id);
        if (entity == null){
            return new ModelAndView("redirect:/sekolah");
        }
        ModelAndView view = new ModelAndView("sekolah/edit");
        view.addObject("sekolah", entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SekolahDto request){
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/sekolah");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute SekolahDto request){
        SekolahEntity result = this.service.getBtId(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/sekolah");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/sekolah");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        SekolahEntity product = this.service.getBtId(id);
        if (product == null){
            return new ModelAndView("redirect:/sekolah");
        }
        ModelAndView view = new ModelAndView("sekolah/detail");
        view.addObject("sekolah", product);
        return view;
    }
}
