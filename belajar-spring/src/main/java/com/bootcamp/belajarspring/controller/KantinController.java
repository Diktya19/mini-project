package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.ProductDto;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cafetaria")
public class KantinController {

   @PostMapping("/kantin1")
    public ResponseEntity<Object> postDataWithRespon1(@RequestBody ProductDto request){
       Response result = new Response(200,"SUCCES",request);
       return ResponseEntity
               .ok()
               .body(result);
   }

   @PostMapping("/kantin2")
    public ResponseEntity<Object> postDataWithRespon2(@RequestBody ProductDto request){
       Response result = new Response(200, "SUCCES", request);
       return ResponseEntity
               .ok()
               .body(result);
   }

   @PostMapping("/kantin3")
    public ResponseEntity<Object> postDataWithRespon3(@RequestBody ProductDto request){
       Response result = new Response(200, "SUCCES", request);
       return ResponseEntity
               .ok()
               .body(result);
   }

   @PostMapping("/kantin4")
    public ResponseEntity<Object> postDataWithRespon4(@RequestBody ProductDto request){
       Response result = new Response(200, "SUCCES", request);
       return ResponseEntity
               .ok()
               .body(result);
   }

   @PostMapping("/kantin5")
    public ResponseEntity<Object> postDataWithRespon(@RequestBody ProductDto request){
       Response result = new Response(200, "SUCCES", request);
       return ResponseEntity
               .ok()
               .body(result);
   }
}
