package com.example.assignment1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    final static public String DB_NAME = "STUDENTS_DB";
    final static public String TABLE_NAME = "STUDENTS";
    final static public String KEY_F_NAME = "FNAME";
    final static public String KEY_L_NAME = "LNAME";
    final static public String KEY_ID = "ID";
    final static public String KEY_AGE = "AGE";
    final static private int VERSION = 1;
    final static private String CREATE_QUERY = "CREATE TABLE "+ TABLE_NAME +" ("+ KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ KEY_F_NAME +" TEXT, "+ KEY_L_NAME +" TEXT, "+ KEY_AGE +" NUMERIC);";


    public DBOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
