package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.entity.CafeEntity;
import com.bootcamp.latihan_spring.entity.CoffeeEntity;
import com.bootcamp.latihan_spring.model.CoffeeDto;
import com.bootcamp.latihan_spring.model.Response;
import com.bootcamp.latihan_spring.service.CoffeeService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    private CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<CoffeeEntity> result = coffeeService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCESS",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        CoffeeEntity result = coffeeService.getByid(id);
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCES",result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CoffeeDto request){
        CoffeeEntity result = coffeeService.save(request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute CoffeeDto request){
        CoffeeEntity result = coffeeService.save(request);
        String message = "SUCCESS";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        CoffeeEntity result = coffeeService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200, "SUCCES", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody CoffeeDto request){
        CoffeeEntity result = coffeeService.update(id, request);
        String message = "SUCCES";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute CoffeeDto request){
        CoffeeEntity result = coffeeService.update(id, request);
        String message = "SUCCES";
        if (result == null){
            message = "FAILED";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }
}
