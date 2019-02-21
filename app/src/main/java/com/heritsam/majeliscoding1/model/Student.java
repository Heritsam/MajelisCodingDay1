package com.heritsam.majeliscoding1.model;

public class Student {
    private String nama, agama, jk;

    public Student(String nama, String agama, String jk) {
        this.nama = nama;
        this.agama = agama;
        this.jk = jk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    //    public Student(String nama, String agama, String jk) {
//        this.nama = nama;
//        this.agama = agama;
//        this.jk = jk;
//    }
}
