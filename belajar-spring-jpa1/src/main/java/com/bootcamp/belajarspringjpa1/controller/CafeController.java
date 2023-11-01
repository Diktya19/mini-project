package com.bootcamp.belajarspringjpa1.controller;

import com.bootcamp.belajarspringjpa1.entity.CafeEntity;
import com.bootcamp.belajarspringjpa1.model.CafeDto;
import com.bootcamp.belajarspringjpa1.model.Response;
import com.bootcamp.belajarspringjpa1.service.CafeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafe")
public class CafeController {

    private CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<CafeEntity> result = cafeService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200,"suucces", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        CafeEntity result = cafeService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200, "success", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CafeDto request){
        CafeEntity result = cafeService.save(request);
        String message = "succes";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute CafeDto request){
        CafeEntity result = cafeService.save(request);
        String message = "success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        CafeEntity result = cafeService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200, "success", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody CafeDto request){
        CafeEntity result = cafeService.update(id, request);
        String message = "success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute CafeDto request){
        CafeEntity result = cafeService.update(id, request);
        String message = "success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }
}
