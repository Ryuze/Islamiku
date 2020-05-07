package com.example.islamiku;

import com.example.islamiku.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JadwalApi {
    @GET("sholat/format/json/Jadwal/kota/688/tanggal/2020-04-07")
    Call<Feed> getData();
}
