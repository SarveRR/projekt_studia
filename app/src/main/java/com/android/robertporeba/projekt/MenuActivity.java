package com.android.robertporeba.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button wyloguj,lista,nowe,edytuj,usun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        wyloguj = (Button)findViewById(R.id.wyloguj);
        lista = (Button)findViewById(R.id.lista);
        nowe = (Button)findViewById(R.id.nowe);
        edytuj = (Button)findViewById(R.id.edytuj);
        usun = (Button)findViewById(R.id.usun);

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
                Intent i = new Intent(MenuActivity.this, ListActivity.class);
                startActivity(i);
            }
        });

        nowe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, NewActivity.class);
                startActivity(i);
            }
        });

        edytuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, EditActivity.class);
                startActivity(i);
            }
        });

        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, DeleteActivity.class);
                startActivity(i);
            }
        });
    }

}
