package com.bootcamp.belajarspringjpa1.controller;

import com.bootcamp.belajarspringjpa1.entity.LaptopEntity;
import com.bootcamp.belajarspringjpa1.model.LaptopDto;
import com.bootcamp.belajarspringjpa1.model.Response;
import com.bootcamp.belajarspringjpa1.service.LaptopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    private LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<LaptopEntity> result = laptopService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        LaptopEntity result = laptopService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody LaptopDto request) {
        LaptopEntity result = laptopService.save(request);
        String message = "Success";
        if (result == null) {
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute LaptopDto request) {
        LaptopEntity result = laptopService.save(request);
        String message = "Succes";
        if (result == null) {
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        LaptopEntity result = laptopService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200, "Success", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody LaptopDto request){
        LaptopEntity result = laptopService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute LaptopDto request){
        LaptopEntity result = laptopService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }
}