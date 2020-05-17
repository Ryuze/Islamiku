package com.example.islamiku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.islamiku.cerpen.CerpenActivity;
import com.example.islamiku.jadwal.JadwalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BtnJadwal = findViewById(R.id.jadwal);
        BtnJadwal.setOnClickListener(this);

        Button BtnCerpen = findViewById(R.id.cerpen);
        BtnCerpen.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jadwal:
                Intent jadwalIntent = new Intent(MainActivity.this, JadwalActivity.class);
                startActivity(jadwalIntent);
                break;
            case R.id.cerpen:
                Intent cerpenIntent = new Intent(MainActivity.this, CerpenActivity.class);
                startActivity(cerpenIntent);
                break;
        }
    }
}
