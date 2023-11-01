package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Peserta;
import com.bootcamp.belajarspring.model.ProductDto;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public ProductDto get() {
        ProductDto data1 = new ProductDto();
        return data1;
    }

    @GetMapping("/data")
    public ProductDto getData() {
        ProductDto food1 = new ProductDto(
                1,
                "Lengko",
                "Lengko Sayur, Sapi, Ayam",
                1000000,
                10);
        return food1;
    }

    @GetMapping("/direct")
    public ProductDto getDirect() {
        return new ProductDto();
    }

    @GetMapping("/direct2")
    public ProductDto getDirect2() {
        return new ProductDto(
                1,
                "Kopi",
                "Kopi Lampung",
                65000,
                1
        );
    }

    @GetMapping("/data2")
    public ProductDto getData2() {
        return new ProductDto(
                2,
                "bakso",
                "Bakso Tangkar",
                25000,
                3
        );
    }

    @GetMapping("/data3")
    public ProductDto getData3() {
        return new ProductDto(
                3,
                "Mie Ayam Bakso",
                "Mie + Bakso",
                25000,
                4
        );
    }

    @GetMapping("/data4")
    public ProductDto getData4(){
        return new ProductDto(
                4,
                "Ayam",
                "Ayam Bakar Samal Ijo",
                30000,
                5
        );
    }

    @GetMapping("/data5")
    public ProductDto getData5(){
        return new ProductDto(
                5,
                "Bebek",
                "Bebek rica-rica",
                35000,
                2
        );
    }

    @GetMapping("/data6")
    public ProductDto getData6(){
        return new ProductDto(
                6,
                "Bebek",
                "Bebek Bakar Samabal Hitam",
                40000,
                1
        );
    }

    @GetMapping("/data7")
    public ProductDto getData7(){
        return new ProductDto(
                7,
                "Ayam",
                "Ayam Bakar Bumbu rica rica",
                35000,
                2
        );
    }

    @GetMapping("/data8")
    public ProductDto getData8(){
        return new ProductDto(
                8,
                "Ikan",
                "Ikan Pedas Manis",
                35000,
                2
        );
    }

    @GetMapping("/data9")
    public ProductDto getData9(){
        return new ProductDto(
                9,
                "Ikan",
                "Ikan Bakar Bumbu",
                30000,
                3
        );
    }

    @PostMapping
    public ResponseEntity<Object> postData(@RequestBody ProductDto request){
        return ResponseEntity
                .ok()
                .body("Data Berhasil Diterima");
    }

    @PostMapping("/with-response")
    public ResponseEntity<Object> postDataWithRespon(@RequestBody ProductDto request){
        Response result = new Response(200, "SUCCES", request);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PostMapping("/peserta-response")
    public ResponseEntity<Object> postDataWithRespon(@RequestBody Peserta request){
        Response result = new Response(200,"SUCCES", request);
        return ResponseEntity
                .ok()
                .body(result);
    }
}