package com.example.sqlite_test;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlite_test.bean.Student;

public class Dao {
    private UsrDBHelper mHelper;

    public Dao(Context context) {
        mHelper = new UsrDBHelper(context);
    }

    //注册  只需姓名学号和密码
    public void insert(Student student) {
        SQLiteDatabase db = mHelper.getWritableDatabase();

        String insert_sql = "INSERT INTO " + UsrDBHelper.TABLE_NAME +
                " (ID,NAME,PASSWORD) VALUES (?,?,?)";
        Object[] obj = {student.getStu_id(), student.getStu_name(), student.getStu_pwd()};

        db.execSQL(insert_sql, obj);
        db.close();
    }

    public String query(Student student) {   //查询某一行
        SQLiteDatabase db = mHelper.getReadableDatabase();

        String query_sql = "select * from " + UsrDBHelper.TABLE_NAME + " where id = " + student.getStu_id();
        Cursor cursor=db.rawQuery(query_sql,null);

        if (0 == cursor.getCount()) {
            return null;
        }
        cursor.moveToFirst();
        int stu_id= cursor.getInt(0);
        System.out.println(stu_id);
        String stu_pwd=  cursor.getString(4);

        cursor.close();
        db.close();
        return stu_id+";"+stu_pwd;

    }
}

