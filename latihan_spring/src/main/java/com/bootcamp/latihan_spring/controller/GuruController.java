package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.entity.GuruEntity;
import com.bootcamp.latihan_spring.model.GuruDto;
import com.bootcamp.latihan_spring.model.Response;
import com.bootcamp.latihan_spring.service.GuruService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/guru")
public class GuruController {
    private GuruService guruService;

    public GuruController(GuruService guruService) {
        this.guruService = guruService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<GuruEntity> result = guruService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCESS",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        GuruEntity result = guruService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS",result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody GuruDto request){
        GuruEntity result = guruService.save(request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message,result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveform(@ModelAttribute GuruDto request){
        GuruEntity result = guruService.save(request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        GuruEntity result = guruService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody GuruDto request){
        GuruEntity result = guruService.update(id, request);
        String mesagge = "SUCCESS";
        if (result == null){
            mesagge = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200,mesagge,result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity updateForm(@PathVariable Integer id,
                                     @ModelAttribute GuruDto request){
        GuruEntity result = guruService.update(id, request);
        String message = "SUCCES";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message, result));
    }
}
