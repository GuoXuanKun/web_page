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




}
