package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.entity.CafeEntity;
import com.bootcamp.latihan_spring.model.CafetariaDto;
import com.bootcamp.latihan_spring.model.Response;
import com.bootcamp.latihan_spring.service.CafeService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/cafetaria")
public class CafetariaController {

    private CafeService cafeService;

    public CafetariaController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<CafeEntity> result = cafeService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200, "Success", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        CafeEntity result = cafeService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200,"Success", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CafetariaDto request){
        CafeEntity result = cafeService.save(request);
        String message = "Succes";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute CafetariaDto request){
        CafeEntity result = cafeService.save(request);
        String message = "Succes";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        CafeEntity result = cafeService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200,"Success",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody CafetariaDto request){
        CafeEntity result = cafeService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message,result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute CafetariaDto request){
        CafeEntity result = cafeService.update(id, request);
        String message = "Succes";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message,result));
    }
}