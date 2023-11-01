package com.bootcamp.belajarspringjpa1.controller;

import com.bootcamp.belajarspringjpa1.entity.OrangEntity;
import com.bootcamp.belajarspringjpa1.model.OrangDto;
import com.bootcamp.belajarspringjpa1.model.Response;
import com.bootcamp.belajarspringjpa1.service.OrangService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orang")
public class OrangController {

    private OrangService orangService;

    public OrangController(OrangService orangService) {
        this.orangService = orangService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<OrangEntity> result = orangService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200, "Success", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        OrangEntity result = orangService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200, "Success", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody OrangDto request){
        OrangEntity result = orangService.save(request);
        String message = "success";
        if (result == null){
            message = "failed";
        }
        return  ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute OrangDto request){
        OrangEntity result = orangService.save(request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        OrangEntity result = orangService.delete(id);
        String message = "succes";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody OrangDto request){
        OrangEntity result = orangService.update(id, request);
        String message = "success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message,result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute OrangDto request){
        OrangEntity result = orangService.update(id, request);
        String message = "success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }
}
