package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.ProductEntity;
import com.bootcamp.belajarspringjpa.model.ProductDto;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//STEP8
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<ProductEntity> result = productService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200, "success", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        ProductEntity result = productService.getByid(id);
        return ResponseEntity.ok()
                .body(new Response(200, "success", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ProductDto request){
        ProductEntity result = productService.save(request);
        String message = "Success";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message,result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute ProductDto request){
        ProductEntity result = productService.save(request);
        String message = "Succes";
        if (result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        ProductEntity result = productService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200,"Success",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody ProductDto request){
        ProductEntity result = productService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200,message,result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute ProductDto request){
        ProductEntity result = productService.update(id, request);
        String message = "Success";
        if (result == null){
            message = "failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }
}
