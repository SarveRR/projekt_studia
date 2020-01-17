package com.android.robertporeba.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {



    DatabaseHelper db;
    EditText email_dane,pass_dane,cpass_dane;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        email_dane=(EditText)findViewById(R.id.id);
        pass_dane=(EditText)findViewById(R.id.status);
        cpass_dane=(EditText)findViewById(R.id.cpass);
        register=(Button)findViewById(R.id.edytuj);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_dane.getText().toString();
                String pass = pass_dane.getText().toString();
                String cpass = cpass_dane.getText().toString();
                if(email.equals("")||pass.equals("")||cpass.equals("")){
                    Toast.makeText(getApplicationContext(),"Pola są puste",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(cpass)){
                        boolean chkemail = db.chkemail(email);
                        if(chkemail==true){
                            boolean insert = db.insert(email,pass);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Rejestracja udana",Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(i);
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email jest zajęty",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Hasła nie są takie same",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
