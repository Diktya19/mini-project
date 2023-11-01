package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.entity.KelasEntity;
import com.bootcamp.latihan_spring.model.KelasDto;
import com.bootcamp.latihan_spring.model.Response;
import com.bootcamp.latihan_spring.service.KelasService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/kelas")
public class KelasController {

    private KelasService kelasService;

    public KelasController(KelasService kelasService) {
        this.kelasService = kelasService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<KelasEntity> result = kelasService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200, "Success", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        KelasEntity result = kelasService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200, "Success", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody KelasDto request){
        KelasEntity result = kelasService.save(request);
        String message = "success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute KelasDto request){
        KelasEntity result = kelasService.save(request);
        String message = "success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        KelasEntity result = kelasService.delete(id);
        String message = "success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody KelasDto request){
        KelasEntity result = kelasService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute KelasDto request){
        KelasEntity result = kelasService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }
}