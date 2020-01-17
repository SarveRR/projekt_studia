package com.android.robertporeba.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText id;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new DatabaseHelper(this);
        id = (EditText) findViewById(R.id.id);
        delete = (Button)findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp= id.getText().toString();

                if (temp.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Puste pole",Toast.LENGTH_SHORT).show();
                }
                else{
                    int id_db=0;

                    try
                    {
                        id_db=Integer.parseInt(temp);

                        Integer dele = db.usunZlecenie(id_db);

                        if(dele==1){
                            Toast.makeText(getApplicationContext(),"Usunięto",Toast.LENGTH_SHORT).show();
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
