package com.android.robertporeba.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    DatabaseHelper db;
    ListView lista;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lista = (ListView)findViewById(R.id.lista);
        db = new DatabaseHelper(this);
        Cursor cursor = db.wyciagZlecenia();

        ArrayList<String> arrayList=new ArrayList<>();

        if(cursor.getCount()==0){
            arrayList.add("Brak zleceń");
        }
        else{
            while (cursor.moveToNext()){
                String nazwa_db = cursor.getString(Integer.parseInt("1"));
                String status_db = cursor.getString(Integer.parseInt("2"));

                arrayList.add(cursor.getString(Integer.parseInt("0"))+"    Nazwa: "+nazwa_db+"   Status: "+status_db);
            }
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        lista.setAdapter(arrayAdapter);
    }
}
