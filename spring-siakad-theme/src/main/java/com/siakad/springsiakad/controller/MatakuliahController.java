package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.MatakuliahModel;
import com.siakad.springsiakad.service.MatakuliahService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/matakuliah")
public class MatakuliahController {
    private final MatakuliahService mataKuliahService;

    public MatakuliahController(MatakuliahService mataKuliahService) {
        this.mataKuliahService = mataKuliahService;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/matakuliah/index");

        List<MatakuliahModel> data = this.mataKuliahService.getAll();
        view.addObject("dataList", data);

        int jmlData = data.size();
        view.addObject("jumlahData", jmlData);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("pages/matakuliah/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MatakuliahModel request){
        // validasi unutk datang kosong
        if (request == null){
            return new ModelAndView("redirect:/matakuliah/add");
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/matakuliah/add");
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/matakuliah/add");
        }

        // call from service
        this.mataKuliahService.save(request);
        // send to view
        return new ModelAndView("redirect:/matakuliah");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        MatakuliahModel data = this.mataKuliahService.getById(id);
        if (data == null){
            return new ModelAndView("redirect:/matakuliah");
        }
        ModelAndView view = new ModelAndView("pages/matakuliah/edit");
        view.addObject("matakuliah", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MatakuliahModel request){
        if (request == null){
            return new ModelAndView("redirect:/matakuliah/edit/"+ request.getId());
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/matakuliah/edit/"+ request.getId());
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/matakuliah/edit/"+ request.getId());
        }
        // call from service
        this.mataKuliahService.update(request, request.getId());
        // send data to view
        return new ModelAndView("redirect:/matakuliah");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        this.mataKuliahService.delete(id);
        return new ModelAndView("redirect:/matakuliah");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/matakuliah/detail");
        MatakuliahModel model = this.mataKuliahService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/matakuliah");
        }

        view.addObject("matakuliah", model);
        return view;
    }
}
