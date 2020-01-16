package com.android.robertporeba.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email_dane,pass_dane;
    Button login,register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        email_dane = (EditText)findViewById(R.id.email);
        pass_dane = (EditText)findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_dane.getText().toString();
                String password = pass_dane.getText().toString();

                Boolean CHkemailpass = db.emailpassword(email,password);
                if (CHkemailpass==true) {
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Złe dane",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
