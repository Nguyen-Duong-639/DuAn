package com.example.dn;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Custom_ngay{
    private String thu;
    private String mua;
    private String ndmax;
    private String ndmin;

    //    private String image;

    public Custom_ngay(String thu, String mua , String ndmax, String ndmin) {
        this.thu = thu;
        this.mua = mua;
        this.ndmax = ndmax;
        this.ndmin = ndmin;
    }

    public Custom_ngay() {
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getMua() {
        return mua;
    }

    public void setMua(String mua) {
        this.mua = mua;
    }

    public String getNdmax() {
        return ndmax;
    }

    public void setNdmax(String ndmax) {
        this.ndmax = ndmax;
    }

    public String getNdmin() {
        return ndmin;
    }

    public void setNdmin(String ndmin) {
        this.ndmin = ndmin;
    }


}
