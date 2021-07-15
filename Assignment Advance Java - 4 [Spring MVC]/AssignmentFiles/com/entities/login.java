package com.entities;

public class login {
    private String uname;
    private String pass;
    public login(String uname, String pass) {
        super();
        this.uname = uname;
        this.pass = pass;
    }
    public login() {
        super();
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
