package com.example.sqlite_test;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlite_test.bean.Student;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText et_register_stuid;
    private EditText et_register_pwd;
    private EditText et_register_name;
    private Button btn_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_register);
        initView();
    }

    private void initView() {
        et_register_stuid = (EditText) findViewById(R.id.et_register_stuid);
        et_register_pwd = (EditText) findViewById(R.id.et_register_pwd);
        et_register_name = (EditText) findViewById(R.id.et_register_name);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
           register();

                break;
        }
    }

    public void register() {
        String  id=et_register_stuid.getText().toString().trim();
        String name=et_register_name.getText().toString().trim();
        String pwd=et_register_pwd.getText().toString().trim();

        if(TextUtils.isEmpty(id)||TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)){
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
        }else{
            Student student= new Student(Integer.parseInt(id),name,pwd);
            Dao dao=new Dao(this);
            if(dao.query(student)!=null){
                Toast.makeText(this, "用户已存在，请直接登陆", Toast.LENGTH_SHORT).show();
            }else{
                dao.insert(student);
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            }
           finish();

        }


    }


}
