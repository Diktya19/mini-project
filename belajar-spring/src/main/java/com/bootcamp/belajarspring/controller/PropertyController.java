package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @GetMapping("/banjarkota")
    public ProductDto getBjrKota(){
        ProductDto property1 = new ProductDto(
                1,
                "Bapak Jeje Jaelani",
                "Jl Dewi Sartika No 19 Kota Banjar",
                500000,
                15
        );
        return property1;
    }

    @GetMapping("/desabanjar")
    public ProductDto getDesaBjr(){
        ProductDto property2 = new ProductDto(
                2,
                "Bapak Jeje Jaelani",
                "Jl Desa Banjar Rt 12 Rw 05 Kota Banjar",
                400000,
                20
        );
        return property2;
    }

    @GetMapping("/langensari")
    public ProductDto getLangensari(){
        ProductDto property3 = new ProductDto(
                3,
                "Bapak Jeje Jaelani",
                "Jl Irigasi No 29 Kota Banjar",
                400000,
                10
        );
        return property3;
    }

    @GetMapping("/handapherang")
    public ProductDto getHandapherang(){
        ProductDto property4 = new ProductDto(
                4,
                "Bapak Hendar Suhendar",
                "Jl Rumah Sakit Rt 10 Rw03 Desa Handapherang",
                450000,
                20
        );
        return property4;
    }

    @GetMapping("/dewasari")
    public ProductDto getDewasari(){
        ProductDto property5 = new ProductDto(
                5,
                "Bapak Hendar Suhendar",
                "Jl Darussalam No 07 Kabupaten Ciamis",
                400000,
                30
        );
        return property5;
    }

    @GetMapping("/karanggedang")
    public ProductDto getKrgGdng(){
        ProductDto property6 = new ProductDto(
                6,
                "Bapak Hendar Suhendar",
                "Jl Nasional Pamalayan No 21 Kabupaten Ciamis",
                350000,
                15
        );
        return property6;
    }

    @GetMapping("/rsciamis")
    public ProductDto getRsCms(){
        ProductDto property7 = new ProductDto(
                7,
                "Bapak Kurnia Alam",
                "Jl RSU Ciamis No 49",
                500000,
                20
        );
        return property7;
    }

    @GetMapping("/ciamiskota")
    public ProductDto getCiamisKota(){
        ProductDto property8 = new ProductDto(
                8,
                "Bapak Kurnia Alam",
                "Jl Alun Alun Ciamis No 34",
                550000,
                20
        );
        return property8;
    }

    @GetMapping("/unigal")
    public ProductDto getUnigal(){
        ProductDto property9 = new ProductDto(
                9,
                "Bapak Kurnia Alam",
                "Jl Raya Kawali dekat Universitas Galuh",
                400000,
                35
        );
        return property9;
    }

    @GetMapping("/kuadanaan")
    public ProductDto getKuadn(){
        ProductDto property10 = new ProductDto(
                10,
                "Bapak Kurnia Alam",
                "Jl Kuadanaan No 17 Kota Ciamis",
                550000,
                15
        );
        return property10;
    }
}
