package com.android.robertporeba.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText nazwa,status;
    Button zapisz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        nazwa =(EditText)findViewById(R.id.id);
        status =(EditText)findViewById(R.id.status);
        zapisz=(Button)findViewById(R.id.edytuj);
        db = new DatabaseHelper(this);

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nazwa_db = nazwa.getText().toString();
                String status_db = status.getText().toString();

                boolean insert = db.insertZlecenia(nazwa_db,status_db);

                if(insert==true){
                    Toast.makeText(getApplicationContext(),"Dodano zlecenie",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Błąd",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
