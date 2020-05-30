package com.example.islamiku.informasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.islamiku.MainActivity;
import com.example.islamiku.R;
import com.example.islamiku.cerpen.CerpenActivity;
import com.example.islamiku.dzikir.DzikirActivity;
import com.example.islamiku.jadwal.JadwalActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

//        inisialisasi dan set variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

//        set selected
        bottomNavigationView.setSelectedItemId(R.id.btmTentang);

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
                        startActivity(new Intent(getApplicationContext(), JadwalActivity.class));
                        break;
                    case R.id.btmCeritaNabi:
                        startActivity(new Intent(getApplicationContext(), CerpenActivity.class));
                        break;
                    case R.id.btmTentang:
                        break;
                }
            }
        });
    }
}
