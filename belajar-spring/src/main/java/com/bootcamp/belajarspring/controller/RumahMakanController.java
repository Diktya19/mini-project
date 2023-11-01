package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class RumahMakanController {

    @GetMapping("/telor")
    public ProductDto getTelor(){
        ProductDto makanan1 = new ProductDto(
                1,
                "Telor",
                "Telor Dadar Balado",
                5000,
                25);
        return makanan1;
    }

    @GetMapping("/ayam")
    public ProductDto getAyam(){
        ProductDto makanan2 = new ProductDto(
                2,
                "Ayam",
                "Ayam Kicap",
                6000,
                45);
        return makanan2;
    }

    @GetMapping("/ayam3")
    public ProductDto getAyam3(){
        ProductDto makanan3 = new ProductDto(
                3,
                "Ayam",
                "Ayam Balado",
                6500,
                45);
        return makanan3;
    }

    @GetMapping("/ayam4")
    public ProductDto getAyam4(){
        ProductDto makanan4 = new ProductDto(
                4,
                "Ayam",
                "Ayam Bakar",
                7000,
                50);
        return makanan4;
    }

    @GetMapping("/perkedel1")
    public ProductDto getPerkedelJag(){
        ProductDto makanan5 = new ProductDto(
                5,
                "Perkedel",
                "Perkedel Jagung",
                3000,
                40);
        return makanan5;
    }

    @GetMapping("/perkedel2")
    public ProductDto getPerkedelOri(){
        ProductDto makanan6 = new ProductDto(
                6,
                "Perkedel",
                "Perkedel Ori",
                3000,
                45);
        return makanan6;
    }

    @GetMapping("/kikil")
    public ProductDto getKikil(){
        ProductDto makanan7 = new ProductDto(
                7,
                "Kikil",
                "Kikil Komplit",
                10000,
                30);
        return makanan7;
    }

    @GetMapping("/babat")
    public ProductDto getBabat(){
        ProductDto makanan8 = new ProductDto(
                8,
                "Babat",
                "Babat Komplit",
                10000,
                30);
        return makanan8;
    }

    @GetMapping("/sate1")
    public ProductDto getSate1(){
        ProductDto makanan9 = new ProductDto(
                9,
                "Sate",
                "Sate Kambing Per Porsi",
                35000,
                20);
        return makanan9;
    }

    @GetMapping("/sate2")
    public ProductDto getSate2(){
        ProductDto makanan10 = new ProductDto(
                10,
                "Sate",
                "Sate Udang",
                15000,
                30);
        return makanan10;
    }
}
