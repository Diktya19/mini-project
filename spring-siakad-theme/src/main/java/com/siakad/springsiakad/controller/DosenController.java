package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.DosenModel;
import com.siakad.springsiakad.service.DosenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dosen")
@RequiredArgsConstructor
public class DosenController {
    private final DosenService dosenService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/dosen/index");

        List<DosenModel> data = this.dosenService.getAll();
        view.addObject("dataList", data);

        int jumlahData = data.size();
        view.addObject("jumlahData", jumlahData);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/dosen/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute DosenModel request){
        if (request == null){
            return new ModelAndView("redirect:/dosen/add");
        }
        if (request.getNip().isEmpty()){
            return new ModelAndView("redirect:/dosen/add");
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/dosen/add");
        }

        // call save from service
        this.dosenService.save(request);
        // redirect to index
        return new ModelAndView("redirect:/dosen");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/dosen/edit");
       DosenModel dosen = this.dosenService.getById(id).orElse(null);
       if (dosen == null){
           return new ModelAndView("redirect:/dosen");
       }

       // data send to view
       view.addObject("dosen", dosen);
       return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute DosenModel request){
        if (request == null){
            return new ModelAndView("redirect:/dosen/edit/"+ request.getId());
        }
        if (request.getNip().isEmpty()){
            return new ModelAndView("redirect:/dosen/edit/"+ request.getId());
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/dosen/edit/"+ request.getId());
        }

        // call save from service
        this.dosenService.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/dosen");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // call delete from service
        this.dosenService.delete(id);
        // redirect to index
        return new ModelAndView("redirect:/dosen");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/dosen/detail");
        // get data from service
        DosenModel model = this.dosenService.getById(id).orElse(null);
        if (model == null){
            return new ModelAndView("redirect:/dosen");
        }

        // send data to view
        view.addObject("dosen", model);
        return view;
    }
}
