package com.java2403.entity;

public class Admin {

    private int ano;
    private String aname;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Admin(int ano, String aname) {
        this.ano = ano;
        this.aname = aname;
    }
}
