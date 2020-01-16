package com.android.robertporeba.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button wyloguj,lista,edycja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        wyloguj = (Button)findViewById(R.id.wyloguj);
        lista = (Button)findViewById(R.id.lista);
        edycja = (Button)findViewById(R.id.edycja);

        wyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(),"Wylogowano",Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"GEJ DETECTED",Toast.LENGTH_SHORT).show();
            }
        });

        edycja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"STRONG GEJ DETECTED",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
