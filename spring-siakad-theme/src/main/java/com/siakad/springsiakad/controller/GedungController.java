package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.GedungModel;
import com.siakad.springsiakad.service.GedungService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/gedung")
@RequiredArgsConstructor
public class GedungController {
    private final GedungService gedungService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/gedung/index");

        List<GedungModel> data = this.gedungService.getAll();
        view.addObject("dataList", data);

        int jumlahData = data.size();
        view.addObject("jumlahData", jumlahData);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/gedung/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute GedungModel request){
        if (request == null){
            return new ModelAndView("redirect:/gedung/add");
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/gedung/add");
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/gedung/add");
        }

        // call save from service
        this.gedungService.save(request);
        // redirect to index
        return new ModelAndView("redirect:/gedung");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/gedung/edit");
       GedungModel data = this.gedungService.getById(id).orElse(null);
       if (data == null){
           return new ModelAndView("redirect:/gedung");
       }

       // data send to view
       view.addObject("gedung", data);
       return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute GedungModel request){
        if (request == null){
            return new ModelAndView("redirect:/gedung/edit/"+ request.getId());
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/gedung/edit/"+ request.getId());
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/gedung/edit/"+ request.getId());
        }

        // call save from service
        this.gedungService.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/gedung");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // call delete from service
        this.gedungService.delete(id);
        // redirect to index
        return new ModelAndView("redirect:/gedung");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/gedung/detail");
        // get data from service
        GedungModel model = this.gedungService.getById(id).orElse(null);
        if (model == null){
            return new ModelAndView("redirect:/gedung");
        }

        // send data to view
        view.addObject("gedung", model);
        return view;
    }
}
