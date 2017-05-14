package com.example.yls.myapplication;

import cn.bmob.v3.BmobObject;

/**
 * Created by yls on 2017/3/7.
 */

public class Person extends BmobObject {


    public  int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public  String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    String name;
    int age;
    int number;


}
