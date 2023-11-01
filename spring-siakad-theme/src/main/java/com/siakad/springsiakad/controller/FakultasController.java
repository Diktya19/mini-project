package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.FakultasModel;
import com.siakad.springsiakad.service.FakultasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/fakultas")
public class FakultasController {
    private final FakultasService fakultasService;

    public FakultasController(FakultasService fakultasService) {
        this.fakultasService = fakultasService;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/fakultas/index");

        List<FakultasModel> dFakultas = this.fakultasService.getAll();
        view.addObject("dataList", dFakultas);

        int jumlahData = dFakultas.size();
        view.addObject("jumlahData", jumlahData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/fakultas/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute FakultasModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/fakultas/add");
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/fakultas/add");
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/fakultas/add");
        }

        // call save from servie
        this.fakultasService.save(request);
        // redirect to index
        return new ModelAndView("redirect:/fakultas");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
       ModelAndView view = new ModelAndView("pages/fakultas/edit");
       FakultasModel data = fakultasService.getById(id).orElse(null);
       if (data == null){
           return new ModelAndView("redirect:/fakultas");
       }

       // data send to view
        view.addObject("fakultas", data);
       return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute FakultasModel request){
        if (request == null){
            return new ModelAndView("redirect:/fakultas/edit/"+ request.getId());
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/fakultas/edit/"+ request.getId());
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/fakultas/edit/"+ request.getId());
        }
        // call save from sevice
        this.fakultasService.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/fakultas");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        this.fakultasService.delete(id);
        return new ModelAndView("redirect:/fakultas");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/fakultas/detail");
        // get data from service
        FakultasModel model = this.fakultasService.getById(id).orElse(null);
        if (model == null){
            return new ModelAndView("redirect:/fakultas");
        }

        // send data to view
        view.addObject("fakultas", model);
        return view;
    }
}