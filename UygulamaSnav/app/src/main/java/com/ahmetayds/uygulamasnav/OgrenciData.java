package com.ahmetayds.uygulamasnav;

import java.io.Serializable;

public class OgrenciData implements Serializable {
    private static final long serialVersionUID = 1L;
    String kullanıcıAdi;
    String sifre;


    public OgrenciData(String kullanıcıAdi, String sifre) {


        this.kullanıcıAdi = kullanıcıAdi;
        this.sifre = sifre;
    }


}
