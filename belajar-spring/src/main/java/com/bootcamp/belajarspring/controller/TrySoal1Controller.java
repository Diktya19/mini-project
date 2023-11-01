package com.bootcamp.belajarspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("try")
public class TrySoal1Controller {

    @GetMapping("full_name")
    public String getName(){
        return "Diktya Pangestu";
    }

    @GetMapping("first_name")
    public String getFisrt(){
        return "Diktya";
    }

    @GetMapping("last_name")
    public String getLast() {
        return "Pangestu";
    }

    @GetMapping("addres")
    public String getAddres(){
        return "Rt 10 Rw 04, Muktisari, Bantarsati, Pamarican, Ciamis";
    }

    @GetMapping("born")
    public String getBorn(){
        return "19/03/90";
    }

    @GetMapping("gender")
    public String getJeniskelamin(){
        return "Laki-Laki";
    }

    @GetMapping("graduate")
    public String getLulusan(){
        return "SMK";
    }

    @GetMapping("hobby")
    public String getHobby(){
        return "Touring";
    }

    @GetMapping("id")
    public Integer getIdcard(){
        return  320012345;
    }

    @GetMapping("expaired")
    public String getBerlaku(){
        return "Seumur Hidup";
    }
}