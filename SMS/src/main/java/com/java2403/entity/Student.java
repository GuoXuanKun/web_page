package com.java2403.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private int sno;
    private String sname;
    private String sex;
    private int age;
    private Date birthday;
    private String password;


    public Student(int sno, String sname, String sex, int age, String password) {
        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.password = password;
    }

    public Student(String sname, String password, String sex, int age) {
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.password = password;
    }

    public Student(int sno,String sname, String password, String sex, int age) {
        this.sno=sno;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.password = password;
    }
}
