package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.FakultasModel;
import com.siakad.springsiakad.model.JurusanModel;
import com.siakad.springsiakad.service.FakultasService;
import com.siakad.springsiakad.service.JurusanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jurusan")
@RequiredArgsConstructor
public class JurusanController {
    private final JurusanService jurusanService;
    private final FakultasService fakultasService;
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/jurusan/index");

        List<JurusanModel> data = this.jurusanService.getAll();
        view.addObject("dataList", data);

        int jumlahData = data.size();
        view.addObject("jumlahData", jumlahData);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/jurusan/add");
        List<FakultasModel> result = this.fakultasService.getAll();

        view.addObject("fakultasList", result);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute JurusanModel request){
        if (request == null){
            return new ModelAndView("redirect:/jurusan/add");
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/jurusan/add");
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/jurusan/add");
        }
       ModelAndView view = new ModelAndView("pages/jurusan/add");
       List<FakultasModel> result = this.fakultasService.getAll();

       view.addObject("fakultasList", result);
       this.jurusanService.save(request);
       return new ModelAndView("redirect:/jurusan");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        JurusanModel data = this.jurusanService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/jurusan");
        }
        List<FakultasModel> result = this.fakultasService.getAll();
        ModelAndView view = new ModelAndView("pages/jurusan/edit");
        view.addObject("fakultasList", result);
        view.addObject("jurusan", data);

        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute JurusanModel request){
        // validsi (harus di isi)
        if (request == null){
            return new ModelAndView("redirect:/jurusan/edit/"+ request.getId());
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/jurusan/edit/"+ request.getId());
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("rediect:/jurusan/edit/"+ request.getId());
        }

        this.jurusanService.update(request, request.getId());
        return new ModelAndView("redirect:/jurusan");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {
        this.jurusanService.delete(id);
        return new ModelAndView("redirect:/jurusan");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/jurusan/detail");
        // get data from service
        JurusanModel model = this.jurusanService.getById(id).orElse(null);
        if (model == null){
            return new ModelAndView("redirect:/jurusan");
        }

        // send data to view
        view.addObject("data", model);
        return view;
    }
}
