package com.example.islamiku.model.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("jadwal")
    @Expose
    private String jadwal;
    @SerializedName("subuh")
    @Expose
    private String subuh;
    @SerializedName("dzuhur")
    @Expose
    private String dzuhur;
    @SerializedName("ashar")
    @Expose
    private String ashar;
    @SerializedName("maghrib")
    @Expose
    private String maghrib;
    @SerializedName("isya")
    @Expose
    private String isya;

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getSubuh() {
        return subuh;
    }

    public void setSubuh(String subuh) {
        this.subuh = subuh;
    }

    public String getDzuhur() {
        return dzuhur;
    }

    public void setDzuhur(String dzuhur) {
        this.dzuhur = dzuhur;
    }

    public String getAshar() {
        return ashar;
    }

    public void setAshar(String ashar) {
        this.ashar = ashar;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    public String getIsya() {
        return isya;
    }

    public void setIsya(String isya) {
        this.isya = isya;
    }

    @Override
    public String toString() {
        return "Data{" +
                "jadwal='" + jadwal + '\'' +
                ", subuh='" + subuh + '\'' +
                ", dzuhur='" + dzuhur + '\'' +
                ", ashar='" + ashar + '\'' +
                ", maghrib='" + maghrib + '\'' +
                ", isya='" + isya + '\'' +
                '}';
    }
}
