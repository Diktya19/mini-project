package com.siakad.springsiakad.controller;

import com.siakad.springsiakad.model.DosenModel;
import com.siakad.springsiakad.model.KelasModel;
import com.siakad.springsiakad.model.MatakuliahModel;
import com.siakad.springsiakad.model.RuanganModel;
import com.siakad.springsiakad.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/kelas")
@RequiredArgsConstructor
public class KelasController {
    private final KelasService kelasService;
    private final DosenService dosenService;
    private final RuanganService ruanganService;
    private final MatakuliahService matakuliahService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/kelas/index");

        List<KelasModel> data = this.kelasService.getAll();
        view.addObject("dataList", data);

        int jumlahData = data.size();
        view.addObject("jumlahData", jumlahData);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/kelas/add");
        // get data dosen
        List<DosenModel> dataDosen = this.dosenService.getAll();
        // get data ruangan
        List<RuanganModel> dataRuangan = this.ruanganService.getAll();
        // get data matakuliah
        List<MatakuliahModel> dataMatakuliah = this.matakuliahService.getAll();

        // data matakuliah send to view
        view.addObject("dataMatakuliah", dataMatakuliah);
        // data ruangan send to view
        view.addObject("dataRuangan", dataRuangan);
        // data dosen send to view
        view.addObject("dataDosen", dataDosen);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute KelasModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/kelas/add");
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/kelas/add");
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/kelas/add");
        }
        ModelAndView view = new ModelAndView("pages/kelas/add");

        // call save from service
        this.kelasService.save(request);
        // redirect to index
        return new ModelAndView("redirect:/kelas");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/kelas/edit");
       KelasModel data = this.kelasService.getById(id).orElse(null);
       if (data == null){
           return new ModelAndView("redirect:/kelas");
       }

       // get data dosen
        List<DosenModel> dataDosen = this.dosenService.getAll();
       // get  data ruangan
        List<RuanganModel> dataRuangan = this.ruanganService.getAll();
        // get data matakuliah
        List<MatakuliahModel> dataMatakuliah = this.matakuliahService.getAll();

        // data matakuliah send to view
        view.addObject("dataMatakuliah", dataMatakuliah);
        // data ruangan send to view
        view.addObject("dataRuangan", dataRuangan);
       // data send to view
        view.addObject("dataDosen", dataDosen);
       // data send to view
       view.addObject("kelas", data);
       return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute KelasModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/kelas/edit/"+ request.getId());
        }
        if (request.getCode().isEmpty()){
            return new ModelAndView("redirect:/kelas/edit/"+ request.getId());
        }
        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/kelas/edit/"+ request.getName());
        }

        // call save from service
        this.kelasService.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/kelas");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // call delete from service
        this.kelasService.delete(id);
        // redirect to index
        return new ModelAndView("redirect:/kelas");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/kelas/detail");
        // get data from service
        KelasModel model = this.kelasService.getById(id).orElse(null);
        if (model == null){
            return new ModelAndView("redirect:/kelas");
        }

        // send data to view
        view.addObject("kelas", model);
        return view;
    }
}
