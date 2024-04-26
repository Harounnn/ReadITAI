package com.example.readitai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "db";

    private static final String FAVOURITES_TABLE = "favourites";
    public DbHandler(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + FAVOURITES_TABLE + " ("
                + "email" + " TEXT,"
                + "url" + " TEXT,"
                + "urltoimage" + " TEXT,"
                + "headline" + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
