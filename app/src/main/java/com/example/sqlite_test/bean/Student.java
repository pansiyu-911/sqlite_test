package com.example.sqlite_test.bean;

@SuppressWarnings("all")
public class Student {
    private  int   stu_id;   //学号
    private  String stu_name;   //姓名
    private char  stu_sex;//性别
    private  float weight;//体重
    private String stu_pwd;  //密码

    public Student(int stu_id, String stu_pwd) {
        this.stu_id = stu_id;
        this.stu_pwd = stu_pwd;
    }

    public Student(int stu_id, String stu_name, String stu_pwd) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_pwd = stu_pwd;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public char getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(char stu_sex) {
        this.stu_sex = stu_sex;
    }
}
