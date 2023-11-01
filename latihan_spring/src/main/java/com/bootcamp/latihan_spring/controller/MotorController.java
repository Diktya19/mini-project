package com.bootcamp.latihan_spring.controller;

import com.bootcamp.latihan_spring.model.Motor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/motorcycle")
public class MotorController {

    @GetMapping("/motor")
    public Motor getMotor(){
        Motor data = new Motor();
        return data;
    }

    @GetMapping("/{nama}/{tipemesin}/{cc}/{transmisi}/{kompresi}/{torsi}/{starter}/{kopling}/{pendinginmesin}/{harga}/{stok}")
    public Motor getMotor(@PathVariable String nama,
                          @PathVariable String tipemesin,
                          @PathVariable String cc,
                          @PathVariable String transmisi,
                          @PathVariable String kompresi,
                          @PathVariable String torsi,
                          @PathVariable String starter,
                          @PathVariable String kopling,
                          @PathVariable String pendinginmesin,
                          @PathVariable int harga,
                          @PathVariable int stok){
        Motor data = new Motor();
        data.setNama(nama);
        data.setTipemesin(tipemesin);
        data.setCc(cc);
        data.setTransmisi(transmisi);
        data.setKompresi(kompresi);
        data.setTorsi(torsi);
        data.setStarter(starter);
        data.setKopling(kopling);
        data.setPendinginmesin(pendinginmesin);
        data.setHarga(harga);
        data.setStok(stok);

        return data;
    }
}
