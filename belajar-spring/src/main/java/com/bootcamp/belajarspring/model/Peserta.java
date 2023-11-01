package com.bootcamp.belajarspring.model;

public class Peserta {
    public int id;
    public String name;
    public String fromschool;
    public String addres;

    public Peserta(int id, String name, String fromschool, String addres) {
        this.id = id;
        this.name = name;
        this.fromschool = fromschool;
        this.addres = addres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromschool() {
        return fromschool;
    }

    public void setFromschool(String fromschool) {
        this.fromschool = fromschool;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
