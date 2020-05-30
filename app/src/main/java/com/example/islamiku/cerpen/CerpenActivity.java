package com.example.islamiku.cerpen;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.example.islamiku.MainActivity;
import com.example.islamiku.R;
import com.example.islamiku.dzikir.DzikirActivity;
import com.example.islamiku.informasi.InfoActivity;
import com.example.islamiku.jadwal.JadwalActivity;
import com.example.islamiku.model.ModelCerpen;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CerpenActivity extends AppCompatActivity implements MainAdapter.onSelectData {

    RecyclerView rvList;
    MainAdapter mainAdapter;
    List<ModelCerpen> modelMain = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerpen);

//        inisialisasi dan set variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

//        set selected
        bottomNavigationView.setSelectedItemId(R.id.btmCeritaNabi);

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
                        break;
                    case R.id.btmTentang:
                        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                        break;
                }
            }
        });

        rvList = findViewById(R.id.rcview);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        loadJSON();
    }
    private void loadJSON() {
        try {
            InputStream stream = getAssets().open("kisah_nabi.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            String tContents = new String(buffer, StandardCharsets.UTF_8);
            try {
                JSONArray obj = new JSONArray(tContents);
                for (int i = 0; i < obj.length(); i++) {
                    JSONObject temp = obj.getJSONObject(i);
                    ModelCerpen dataApi = new ModelCerpen();
                    dataApi.setName(temp.getString("name"));
                    dataApi.setThn_kelahiran(temp.getString("thn_kelahiran"));
                    dataApi.setUsia(temp.getString("usia"));
                    dataApi.setDescription(temp.getString("description"));
                    dataApi.setTmp(temp.getString("tmp"));
                    dataApi.setImage_url(temp.getString("image_url"));
                    modelMain.add(dataApi);
                    mainAdapter = new MainAdapter(CerpenActivity.this, modelMain, this);
                    rvList.setAdapter(mainAdapter);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException ignored) {

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelected(ModelCerpen modelMain) {
        Intent intnt = new Intent(CerpenActivity.this, DetailActivity.class);
        intnt.putExtra("paramDtl", modelMain);
        startActivity(intnt);
    }
}
