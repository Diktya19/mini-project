package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.ProductDto;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showroom")
public class DallerController {

    @GetMapping("/buyer1")
    public ResponseEntity<Object> postDataWithRespon(){
        ProductDto buyer1 = new ProductDto(
                1,
                "HONDA beAT",
                "beAT 110cc Warna Putih Biru NoPol (Z 6878 YY)",
                21000000,
                1);
        Response result = new Response(200,"SUCCES", buyer1);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer2")
    public ResponseEntity<Object> postDataWithRespon2(){
        ProductDto buyer2 = new ProductDto(
                2,
                "HONDA MOTOR",
                "Vario 160cc Warna Hitam Dop NoPol (Z 3434 YT)",
                32000000,
                1);
        Response result = new Response(200,"SUCCES",buyer2);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer3")
    public ResponseEntity<Object> postDataWithRespon3(){
        ProductDto buyer3 = new ProductDto(
                3,
                "YAMAHA MOTOR",
                "Aerox 155cc Warna Hitam Glossy NoPol (Z 5674 TAQ)",
                32000000,
                1);
        Response result = new Response(200,"SUCCES",buyer3);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer4")
    public ResponseEntity<Object> postDataWithRespon4(){
        ProductDto buyer4 = new ProductDto(
                4,
                "YAMAHA MOTOR",
                "NMAX 155cc Warna Putih Glossy NoPol (Z 1000 TU)",
                31000000,
                1);
        Response result = new Response(200,"SUCCES",buyer4);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer5")
    public ResponseEntity<Object> postDataWithRespon5(){
        ProductDto buyer5 = new ProductDto(
                5,
                "HONDA MOTOR",
                "PCX 160cc Warna Merah Marun NoPol (Z 3333 TI)",
                34000000,
                1);
        Response result = new Response(200,"SUCCES", buyer5);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer6")
    public ResponseEntity<Object> posDataWithRespon6(){
        ProductDto buyer6 = new ProductDto(
                6,
                "KAWASAKI MOTOR",
                "ZX 250R Warna Biru Hitam NoPol (Z 16 ZAG)",
                110000000,
                1);
        Response result = new Response(200,"SUCCES",buyer6);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer7")
    public ResponseEntity<Object> postDataWithRespon7(){
        ProductDto buyer7 = new ProductDto(
                7,
                "KAWASAKI MOTOR",
                "Ninja SS 150cc Warna Kuning NoPol (Z 1 Z)",
                65000000,
                1);
        Response result = new Response(200,"SUCCES",buyer7);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer8")
    public ResponseEntity<Object> postDataWithRespon8(){
        ProductDto buyer8 = new ProductDto(
                8,
                "SUZUKI",
                "FuFi DOHC 150cc Warna Hitam NoPol (Z 6666 YY)",
                21000000,
                1);
        Response result = new Response(200, "SUCCES", buyer8);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer9")
    public ResponseEntity<Object> postDataWithRespon9(){
        ProductDto buyer9 = new ProductDto(
                9,
                "KTM MOTOR",
                "Duke 390cc Warna Orange Putih NoPol(Z 2323 YU)",
                45000000,
                1);
        Response result = new Response(200, "SUCCES", buyer9);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer10")
    public ResponseEntity<Object> postDataWithRespon10(){
        ProductDto buyer10 = new ProductDto(
                10,
                "YAMAHA MOTOR",
                "R6 600cc Warna Biru Putih NoPol (D 3344 II)",
                210000000,
                1);
        Response result = new Response(200,"SUCCES", buyer10);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/buyer11")
    public ResponseEntity<Object> postDataWithRespon11(){
        ProductDto buyer11 = new ProductDto(
                10,
                "KAWASAKI MOTOR",
                "ZX 636 630cc Warna Hijau SE NoPol (D 777 AUH)",
                260000000,
                1);
        Response result = new Response(200,"SUCCES",buyer11);
        return ResponseEntity
                .ok()
                .body(result);
    }
}
