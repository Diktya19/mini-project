package com.bootcamp.mvc01.controller;

import com.bootcamp.mvc01.dto.SiswaDto;
import com.bootcamp.mvc01.entity.SiswaEntity;
import com.bootcamp.mvc01.service.SiswaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/siswa")
public class SiswaController {
    private final SiswaService service;

    public SiswaController(SiswaService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("siswa/index");

        String judul = "List Siswa";
        view.addObject("dataJudul", judul);

        List<SiswaEntity> dataSiswa = this.service.getAll();
        view.addObject("listSiswa", dataSiswa);

        int jumlahData = dataSiswa.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("siswa/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SiswaDto request) {
        this.service.save(request);
        return new ModelAndView ("redirect:/siswa");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        SiswaEntity entity = this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/siswa");
        }
        ModelAndView view = new ModelAndView("siswa/edit");
        view.addObject("siswa", entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SiswaDto request) {
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/siswa");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute SiswaDto request) {
        SiswaEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/siswa");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/siswa");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        SiswaEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/siswa");
        }
        ModelAndView view = new ModelAndView("siswa/detail");
        view.addObject("siswa", product);
        return view;
    }
}