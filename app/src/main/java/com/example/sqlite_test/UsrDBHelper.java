package com.example.sqlite_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsrDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "student.db";
    public static  final int DB_VERSION=1;
    public static final String TABLE_NAME="info";   //表名

    public UsrDBHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table_sql="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+
                "ID INTEGER PRIMARY KEY NOT NULL," +
                "NAME VARCHAR,SEX VARCHAR,WEIGHT REAL,PASSWORD VARCHAR)";

        db.execSQL(create_table_sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
