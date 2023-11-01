package com.bootcamp.belajarspringjpa1.controller;

import com.bootcamp.belajarspringjpa1.entity.MotorEntity;
import com.bootcamp.belajarspringjpa1.model.MotorDto;
import com.bootcamp.belajarspringjpa1.model.Response;
import com.bootcamp.belajarspringjpa1.service.MotorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motor")
public class Motorcontroller {

    private MotorService motorService;

    public Motorcontroller(MotorService motorService) {
        this.motorService = motorService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<MotorEntity> result = motorService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        MotorEntity result = motorService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCESS", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody MotorDto request){
        MotorEntity result = motorService.save(request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, request));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute MotorDto request){
        MotorEntity result = motorService.save(request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        MotorEntity result = motorService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200, "Success", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody MotorDto request){
        MotorEntity result = motorService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute MotorDto request){
        MotorEntity result = motorService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message, result));
    }
}
