package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.model.Sekolah;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banjar")
public class SekolahController {

    @GetMapping("/sekolah")
    public Sekolah getSekolah(){
        Sekolah data = new Sekolah();
        return data;
    }

    @GetMapping("/{kode}/{nama}/{alamat}/{kepsek}/{masajabatan}/{gedung}/{jumlahmurid}/{jumlahoperator}")
    public Sekolah getSekolah(@PathVariable int kode,
                              @PathVariable String nama,
                              @PathVariable String alamat,
                              @PathVariable String kepsek,
                              @PathVariable int masajabatan,
                              @PathVariable int gedung,
                              @PathVariable int jumlahmurid,
                              @PathVariable int jumlahoperator){
        Sekolah data = new Sekolah();
        data.setKode(kode);
        data.setNama(nama);
        data.setAlamat(alamat);
        data.setKepsek(kepsek);
        data.setMasajabatan(masajabatan);
        data.setGedung(gedung);
        data.setJumlahmurid(jumlahmurid);
        data.setJumlahoperator(jumlahoperator);

        return data;
    }
}
