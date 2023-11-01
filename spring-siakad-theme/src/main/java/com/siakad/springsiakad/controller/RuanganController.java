package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.GedungModel;
import com.siakad.springsiakad.model.RuanganModel;
import com.siakad.springsiakad.service.GedungService;
import com.siakad.springsiakad.service.RuanganService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ruangan")
@RequiredArgsConstructor
public class RuanganController {
    private final RuanganService ruanganService;
    private final GedungService gedungService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/ruangan/index");

        List<RuanganModel> data = this.ruanganService.getAll();
        view.addObject("dataList", data);

        int jumlahData = data.size();
        view.addObject("jumlahData", jumlahData);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/ruangan/add");
        // get data gedung
        List<GedungModel> dataGedung = this.gedungService.getAll();
        // data send to view
        view.addObject("dataGedung", dataGedung);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RuanganModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/ruangan/add");
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/ruangan/add");
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/ruangan/add");
        }
        // call save fromm service
        this.ruanganService.save(request);
        // redirect to index
        return new ModelAndView("redirect:/ruangan");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/ruangan/edit");
       RuanganModel data = this.ruanganService.getById(id).orElse(null);
       if (data == null){
           return new ModelAndView("redirect:/ruangan");
       }

       // get data gedung
        List<GedungModel> dataGedung = this.gedungService.getAll();
       // data send to view
        view.addObject("dataGedung", dataGedung);

        // data send to view
        view.addObject("ruangan", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RuanganModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/ruangan/add"+ request.getId());
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/ruangan/add"+ request.getId());
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/ruangan/add"+ request.getId());
        }
        // call save from service
        this.ruanganService.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/ruangan");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        this.ruanganService.delete(id);
        return new ModelAndView("redirect:/ruangan");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/ruangan/detail");
        // get data from service
        RuanganModel data = this.ruanganService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/ruangan");
        }

        // send data to view
        view.addObject("ruangan", data);
        return view;
    }
}
