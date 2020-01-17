package com.android.robertporeba.projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "BazaDanych.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key,password text)");
        db.execSQL("Create table zlecenia(id INTEGER primary key AUTOINCREMENT,nazwa text, status text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists zlecenia");
        onCreate(db);
    }

    public boolean insert (String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);

        if (ins==-1) return false;
        else return true;
    }

    public boolean chkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email=?",new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public boolean emailpassword(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email=? AND password=?",new String[]{email,password});
        if (cursor.getCount()>0) return true;
        else return false;
    }

    public boolean insertZlecenia(String nazwa, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa",nazwa);
        contentValues.put("status",status);

        long ins = db.insert("zlecenia",null,contentValues);

        if (ins==-1) return false;
        else return true;

    }

    public Cursor wyciagZlecenia(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM zlecenia",null);
        return cursor;
    }

    public Integer usunZlecenie(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("zlecenia","id=?",new String[]{id.toString()});
    }

    public boolean editZlecenie(Integer id, String nazwa, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa",nazwa);
        contentValues.put("status",status);

        db.update("zlecenia",contentValues,"id="+id,null);

        return true;
    }
}
