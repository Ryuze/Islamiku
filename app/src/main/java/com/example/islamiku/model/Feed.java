package com.example.islamiku.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feed {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("query")
    @Expose
    private Query query;
    @SerializedName("jadwal")
    @Expose
    private Jadwal jadwal;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "status='" + status + '\'' +
                ", query=" + query +
                ", Jadwal=" + jadwal +
                '}';
    }
}
