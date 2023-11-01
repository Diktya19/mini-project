package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Peserta;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class MuridBaruController {

    @GetMapping("/siswa-response")
    public ResponseEntity<Object> postDataWithResponse(){
        Peserta data = new Peserta
                (1,
                "Diktya Pangestu",
                "MTS N BANJAR",
                "PAMARICAN");
        Response result = new Response(200,"SUCCES", data);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PostMapping("/siswa-response")
    public ResponseEntity<Object> postDataWithRespon(@RequestBody Peserta request){
        Response result = new Response(200,"SUCCES", request);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/siswa2-response")
    public ResponseEntity<Object> postDataWithRespon2() {
        Peserta data2 = new Peserta(
                2,
                "Budi Hermawan",
                "MTS N BANJAR",
                "BANJAR");
        Response result = new Response(200, "SUCCES", data2);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PostMapping("/siswa2-response")
    public ResponseEntity<Object> postDataWithRespon2(@RequestBody Peserta request){
        Response result = new Response(200,"SUCCES",request);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/siswa3-response")
    public ResponseEntity<Object> postDataWithRespon3(){
        Peserta data3 = new Peserta(
                3,
                "Cika Citata",
                "SMP N 1 BJR",
                "Kawali");
        Response result = new Response(200,"SUCCES",data3);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PostMapping("/siswa3-response")
    public ResponseEntity<Object> postDataWithResponse3(@RequestBody Peserta request){
        Response result = new Response(200,"SUCCES",request);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/siswa4-response")
    public ResponseEntity<Object> postDataWithResponse4(){
        Peserta data4 = new Peserta(
                4,
                "Dede Hartono",
                "SMP N 2 BJR",
                "CISAGA");
        Response result = new Response(200,"SUCCES",data4);
        return ResponseEntity
                .ok()
                .body(result);
    }
}
