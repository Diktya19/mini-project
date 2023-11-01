package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.entity.GudangEntity;
import com.bootcamp.latihan_spring.model.GudangDto;
import com.bootcamp.latihan_spring.model.Response;
import com.bootcamp.latihan_spring.service.GudangService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/gudang")
public class GudangController {
    private GudangService gudangService;

    public GudangController(GudangService gudangService) {
        this.gudangService = gudangService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<GudangEntity> result = gudangService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        GudangEntity result = gudangService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody GudangDto request){
        GudangEntity result = gudangService.save(request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute GudangDto request){
        GudangEntity result = gudangService.save(request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        GudangEntity result = gudangService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody GudangDto request){
        GudangEntity result = gudangService.update(id, request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute GudangDto request){
        GudangEntity result = gudangService.update(id, request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }
}
