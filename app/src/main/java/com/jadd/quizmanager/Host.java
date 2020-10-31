package com.jadd.quizmanager;

public class Host {
    String eMail, name;

    public Host(){

    }

    public Host(String eMail, String name) {
        this.eMail = eMail;
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
