package com.example.islamiku;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.islamiku.model.Feed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class percobaan_awal extends AppCompatActivity {
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textResult = findViewById(R.id.text_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.banghasan.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JadwalApi jadwalApi = retrofit.create(JadwalApi.class);
        Call<Feed> call = jadwalApi.getData();

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(response.isSuccessful()) {
                    textResult.setText("Tanggal: " + response.body().getJadwal().getData().getDzuhur());
//                    return tanggal;
                }

            }

            @Override
//            public void onFailure(Call<List<Jadwal>> call, Throwable t) {
            public void onFailure(Call<Feed> call, Throwable t) {
                textResult.setText(t.getMessage());
            }
        });
    }
}
