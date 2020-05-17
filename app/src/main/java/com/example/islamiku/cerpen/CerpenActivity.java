package com.example.islamiku.cerpen;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.islamiku.R;

public class CerpenActivity extends AppCompatActivity {
    private Button adam, idris, nuh, hud;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerpen);

        adam = (Button)findViewById(R.id.button1);
        idris = (Button)findViewById(R.id.button2);
        nuh = (Button)findViewById(R.id.button3);
        hud = (Button)findViewById(R.id.button4);

        adam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adamIntent = new Intent(getApplicationContext(),AdamActivity.class);
                startActivity(adamIntent);
            }
        });
        idris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idrisIntent = new Intent(getApplicationContext(),IdrisActivity.class);
                startActivity(idrisIntent);
            }
        });
    }
}
