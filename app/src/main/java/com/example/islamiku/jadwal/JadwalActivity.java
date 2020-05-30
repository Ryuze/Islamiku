package com.example.islamiku.jadwal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.islamiku.JadwalApi;
import com.example.islamiku.MainActivity;
import com.example.islamiku.R;
import com.example.islamiku.cerpen.CerpenActivity;
import com.example.islamiku.dzikir.DzikirActivity;
import com.example.islamiku.informasi.InfoActivity;
import com.example.islamiku.model.Feed;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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

//        inisialisasi dan set variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

//        set selected
        bottomNavigationView.setSelectedItemId(R.id.btmJadwalSholat);

//        itemselectlistener
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btmDzikir:
                        startActivity(new Intent(getApplicationContext(), DzikirActivity.class));
                        break;
                    case R.id.btmHome:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;
                    case R.id.btmJadwalSholat:
                        break;
                    case R.id.btmCeritaNabi:
                        startActivity(new Intent(getApplicationContext(), CerpenActivity.class));
                        break;
                    case R.id.btmTentang:
                        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                        break;
                }
            }
        });

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
                ashar.setText("Ashar " +response.body().getJadwal().getData().getAshar());
                maghrib.setText("Maghrib " +response.body().getJadwal().getData().getMaghrib());
                isya.setText("Isya " +response.body().getJadwal().getData().getIsya());

                subuh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] tmp = response.body().getJadwal().getData().getSubuh().split(":");
                        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(tmp[0]));
                        intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(tmp[1]));
                        startActivity(intent);
                    }
                });

                dzuhur.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] tmp = response.body().getJadwal().getData().getDzuhur().split(":");
                        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(tmp[0]));
                        intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(tmp[1]));
                        startActivity(intent);
                    }
                });

                ashar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] tmp = response.body().getJadwal().getData().getAshar().split(":");
                        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(tmp[0]));
                        intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(tmp[1]));
                        startActivity(intent);
                    }
                });

                maghrib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] tmp = response.body().getJadwal().getData().getMaghrib().split(":");
                        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(tmp[0]));
                        intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(tmp[1]));
                        startActivity(intent);
                    }
                });

                isya.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] tmp = response.body().getJadwal().getData().getIsya().split(":");
                        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(tmp[0]));
                        intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(tmp[1]));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Terdeteksi masalah " + t, Toast.LENGTH_LONG);
            }
        });
    }
}
