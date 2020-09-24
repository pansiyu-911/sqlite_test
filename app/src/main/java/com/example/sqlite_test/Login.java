package com.example.sqlite_test;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlite_test.bean.Student;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText et_stuId;
    private EditText et_stuPwd;
    private Button btn_login;
    private TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_login);
        initView();


    }

    private void initView() {
        et_stuId = (EditText) findViewById(R.id.et_stuid);
        et_stuPwd = (EditText) findViewById(R.id.et_stupwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_register = (TextView) findViewById(R.id.tv_register);

        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                login();
                break;
            case R.id.tv_register:
                Intent intent=new Intent(this,Register.class);
                startActivity(intent);
        }
    }

    public void login() {

        String stu_id = et_stuId.getText().toString().trim();
        String stu_pwd = et_stuPwd.getText().toString().trim();
        if (TextUtils.isEmpty(stu_id) || TextUtils.isEmpty(stu_pwd)) {
            Toast.makeText(this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
        } else {

            Student student = new Student(Integer.parseInt(stu_id), stu_pwd);
            Dao dao = new Dao(this);
            String result = dao.query(student);
            if (result == null || result.length() == 0) {
                Toast.makeText(this, "用户不存在，请先注册", Toast.LENGTH_SHORT).show();
            } else{
                String[] a = result.split(";");
                String  id = a[0];
                String pwd = a[1];
                if (stu_id.equals(id)  && stu_pwd.equals(pwd)) {
                    Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "用户或密码错误，登陆失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


}
