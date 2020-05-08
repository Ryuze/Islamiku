package com.example.islamiku;

import com.example.islamiku.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JadwalApi {
    @GET("sholat/format/json/Jadwal/kota/688/tanggal/{tgl}")
    Call<Feed> getData(@Path("tgl") String tanggal);
}
