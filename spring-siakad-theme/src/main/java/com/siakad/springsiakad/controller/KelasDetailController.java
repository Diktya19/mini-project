package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.KelasDetailModel;
import com.siakad.springsiakad.model.KelasModel;
import com.siakad.springsiakad.model.MahasiswaModel;
import com.siakad.springsiakad.service.KelasDetailService;
import com.siakad.springsiakad.service.KelasService;
import com.siakad.springsiakad.service.MahasiswaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/kelasdetail")
@RequiredArgsConstructor
public class KelasDetailController {
    private final KelasDetailService kelasDetailService;
    private final KelasService kelasService;
    private final MahasiswaService mahasiswaService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("pages/kelasdetail/index");

        List<KelasDetailModel> data = this.kelasDetailService.getAll();
        view.addObject("kelasDetailList", data);

        int jmlData = data.size();
        view.addObject("jumlahData", jmlData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView view = new ModelAndView("pages/kelasdetail/add");
        // get data from kelas
        List<KelasModel> kelas = this.kelasService.getAll();
        // get data from mahasiswa
        List<MahasiswaModel> mahasiswa = this.mahasiswaService.getAll();

        view.addObject("dataKelas", kelas);
        view.addObject("dataMahasiswa", mahasiswa);

        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute KelasDetailModel request) {
        if (request == null){
            return new ModelAndView("redirect:/kelasdetail/add");
        }
        if (request.getStatus().isEmpty()){
            return new ModelAndView("redirect:/kelasdetail/add");
        }

        // call data save from service
        kelasDetailService.save(request);
        // send to view
        return new ModelAndView("redirect:/kelasdetail");

    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/kelasdetail/edit");
        KelasDetailModel model = kelasDetailService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/kelasdetail");
        }

        List<MahasiswaModel> mahasiswa = mahasiswaService.getAll();
        List<KelasModel> kelas = kelasService.getAll();

        view.addObject("kelasDetail", model);
        view.addObject("dataMahasiswa", mahasiswa);
        view.addObject("dataKelas", kelas);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute KelasDetailModel request) {
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/kelasdetail/edit/"+ request.getId());
        }
        if (request.getStatus().isEmpty()){
            return new ModelAndView("redirect:/kelasdetail/edit/"+ request.getId());
        }
        // call data from service
        this.kelasDetailService.update(request, request.getId());
        // send to view
        return new ModelAndView("redirect:/kelasdetail");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
       ModelAndView view = new ModelAndView("pages/kelasdetail/detail");
       KelasDetailModel model = kelasDetailService.getById(id);
       if (model == null){
           return new ModelAndView("redirect:/kelasDetail");
       }
       view.addObject("kelasDetailList", model);
       return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {
        this.kelasDetailService.delete(id);
        return new ModelAndView("redirect:/kelasdetail");
    }
}
