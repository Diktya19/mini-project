package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.FakultasModel;
import com.siakad.springsiakad.model.JurusanModel;
import com.siakad.springsiakad.model.MahasiswaModel;
import com.siakad.springsiakad.service.FakultasService;
import com.siakad.springsiakad.service.JurusanService;
import com.siakad.springsiakad.service.MahasiswaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mahasiswa")
@RequiredArgsConstructor
public class MahasiswaController {
    private final MahasiswaService mahasiswaService;
    private final JurusanService jurusanService;
    private final FakultasService fakultasService;


    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/mahasiswa/index");

        List<MahasiswaModel> data = this.mahasiswaService.getAll();
        view.addObject("dataList", data);

        int jmlData = data.size();
        view.addObject("jumlahData", jmlData);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/mahasiswa/add");
        // get data jurusan
        List<JurusanModel> dataJurusan = this.jurusanService.getAll();
        // get data fakultas
        List<FakultasModel> dataFakultas = this.fakultasService.getAll();
        // data fakultas kirim ke view
        view.addObject("dataFakultas", dataFakultas);
        // data jurusan kirim ke view
        view.addObject("dataJurusan", dataJurusan);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MahasiswaModel request){
        if (request == null){
            return new ModelAndView("redirect:/mahasiswa/add");
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/mahasiswa/add");
        }
        if (request.getNim().isEmpty()){
            return new ModelAndView("redirect:/mahasiswa/add");
        }

        // call save from service
        this.mahasiswaService.save(request);
        // redirect to index
        return new ModelAndView("redirect:/mahasiswa");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/mahasiswa/edit");
        MahasiswaModel data = this.mahasiswaService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/mahasiswa");
        }

        // get data jurusan
        List<JurusanModel> dataJurusan = this.jurusanService.getAll();
        // get data fakultas
        List<FakultasModel> dataFakultas = this.fakultasService.getAll();
        // data fakultas send to view
        view.addObject("dataFakultas", dataFakultas);
        // data jurusan send to view
        view.addObject("dataJurusan", dataJurusan );

        // data send to view
        view.addObject("mahasiswa", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MahasiswaModel request){
        if (request == null){
            return new ModelAndView("redirect:/mahasiswa/edit/"+ request.getId());
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/mahasiswa/edit/"+ request.getId());
        }
        if (request.getNim().isEmpty()){
            return new ModelAndView("redirect:/mahasiswa/edit/"+ request.getId());
        }

        // call save from service
        this.mahasiswaService.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/mahasiswa");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        this.mahasiswaService.delete(id);
        return new ModelAndView("redirect:/mahasiswa");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/mahasiswa/detail");
        // get data from service
        MahasiswaModel data = this.mahasiswaService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/mahasiswa");
        }

        // send data to view
        view.addObject("mahasiswa", data);
        return view;
    }
}
