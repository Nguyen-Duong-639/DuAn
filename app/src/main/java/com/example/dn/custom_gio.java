package com.example.dn;

public class custom_gio {
    private String gio;
    private String mua;
    private String temp;

    public custom_gio(String gio, String mua, String temp) {
        this.gio = gio;
        this.mua = mua;
        this.temp = temp;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getMua() {
        return mua;
    }

    public void setMua(String mua) {
        this.mua = mua;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
