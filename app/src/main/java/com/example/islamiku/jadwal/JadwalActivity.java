package com.example.islamiku.jadwal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.islamiku.JadwalApi;
import com.example.islamiku.R;
import com.example.islamiku.model.Feed;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JadwalActivity extends AppCompatActivity {
    private TextView tanggal, subuh, dzuhur, ashar, maghrib, isya;
    private JadwalApi jadwalApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        tanggal = findViewById(R.id.tanggal);
        subuh = findViewById(R.id.subuh);
        dzuhur = findViewById(R.id.dzuhur);
        ashar = findViewById(R.id.ashar);
        maghrib = findViewById(R.id.maghrib);
        isya = findViewById(R.id.isya);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.banghasan.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jadwalApi = retrofit.create(JadwalApi.class);
        getJadwal();
    }

    private void getJadwal() {
        SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd", Locale.US);
        String jadwal = currentDate.format(new Date());

        Call<Feed> call = jadwalApi.getData(jadwal);

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                tanggal.setText(response.body().getJadwal().getData().getTanggal());
                subuh.setText("Subuh " + response.body().getJadwal().getData().getSubuh());
                dzuhur.setText("Dzuhur " +response.body().getJadwal().getData().getDzuhur());
                ashar.setText("Ashar " +response.body().getJadwal().getData().getDzuhur());
                maghrib.setText("Maghrib " +response.body().getJadwal().getData().getMaghrib());
                isya.setText("Isya " +response.body().getJadwal().getData().getIsya());
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Terdeteksi masalah " + t, Toast.LENGTH_LONG);
            }
        });
    }
}
