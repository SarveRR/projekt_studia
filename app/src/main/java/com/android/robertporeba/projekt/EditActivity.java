package com.android.robertporeba.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText id,nazwa,status;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        db = new DatabaseHelper(this);
        id = (EditText) findViewById(R.id.id);
        nazwa = (EditText) findViewById(R.id.nazwa);
        status = (EditText) findViewById(R.id.status);
        edit = (Button)findViewById(R.id.edytuj);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nazwa_db= nazwa.getText().toString();
                String status_db= status.getText().toString();
                String temp= id.getText().toString();

                if (temp.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Puste pole",Toast.LENGTH_SHORT).show();
                }
                else{
                    int id_db=0;

                    try
                    {
                        id_db=Integer.parseInt(temp);

                        int update = db.editZlecenie(id_db,nazwa_db,status_db);

                        if(update==1){
                            Toast.makeText(getApplicationContext(),"Edytowano",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Zły numer",Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getApplicationContext(),"Zła wartość",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
