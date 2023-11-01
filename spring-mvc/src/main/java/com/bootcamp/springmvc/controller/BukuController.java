package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.BukuEntity;
import com.bootcamp.springmvc.model.BukuDto;
import com.bootcamp.springmvc.service.BukuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/buku")
public class BukuController {

    private final BukuService service;

    public BukuController(BukuService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("buku/index");
        String judul = "List Buku";
        view.addObject("dataJudul", judul);

        List<BukuEntity> dataBuku = this.service.getAll();
        view.addObject("listBuku", dataBuku);

        int jumlahData = dataBuku.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("buku/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute BukuDto request){
        this.service.save(request);
        return new ModelAndView("redirect:/buku");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        BukuEntity entity = this.service.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/buku");
        }
        ModelAndView view = new ModelAndView("buku/edit");
        view.addObject("buku", entity);
        return view;
    }

    @PostMapping("/update")
    public  ModelAndView update(@ModelAttribute BukuDto request){
        this.service.update(request.getId(), request);
        return new ModelAndView("redirect:/buku");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute BukuDto request){
        BukuEntity result = this.service.getById(request.getId());
        if (result == null){
            return new ModelAndView("redirect:/buku");
        }
        this.service.delete(request.getId());
        return new ModelAndView("redirect:/buku");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        BukuEntity product = this.service.getById(id);
        if (product == null){
            return new ModelAndView("redirect:/buku");
        }
        ModelAndView view = new ModelAndView("buku/detail");
        view.addObject("buku", product);
        return view;
    }
}
