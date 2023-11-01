package com.bootcamp.belajarspringjpa1.controller;
import com.bootcamp.belajarspringjpa1.entity.PropertyEntity;
import com.bootcamp.belajarspringjpa1.model.PropertyDto;
import com.bootcamp.belajarspringjpa1.model.Response;
import com.bootcamp.belajarspringjpa1.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<PropertyEntity> result = propertyService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200, "success", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        PropertyEntity result = propertyService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200, "Success", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody PropertyDto request){
        PropertyEntity result = propertyService.save(request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, request));
    }
}