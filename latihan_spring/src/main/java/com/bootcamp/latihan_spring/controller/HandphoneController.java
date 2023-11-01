package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.entity.HandphoneEntity;
import com.bootcamp.latihan_spring.model.HandphoneDto;
import com.bootcamp.latihan_spring.model.Response;
import com.bootcamp.latihan_spring.service.HandphoneService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/phone")
public class HandphoneController {
    private HandphoneService handphoneService;

    public HandphoneController(HandphoneService handphoneService) {
        this.handphoneService = handphoneService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<HandphoneEntity> result = handphoneService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCESS", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        HandphoneEntity result = handphoneService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCESS",result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody HandphoneDto request){
        HandphoneEntity result = handphoneService.save(request);
        String message = "SUCCESS";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message,result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute HandphoneDto request){
        HandphoneEntity result = handphoneService.save(request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        HandphoneEntity result = handphoneService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCESS",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody HandphoneDto request){
        HandphoneEntity result = handphoneService.update(id, request);
        String mesagge = "SUCCESS";
        if (result == null){
            mesagge = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200,mesagge,result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity updateForm(@PathVariable Integer id,
                                     @ModelAttribute HandphoneDto request){
        HandphoneEntity result = handphoneService.update(id, request);
        String message = "SUCCES";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message, result));
    }
}
