package com.example.dell.androidfrontend;

/**
 * Created by Kosha on 31-05-2017.
 */

public class ULogin {

    String email_id;
    String password;

    public ULogin(String email_id, String password) {
        this.email_id = email_id;
        this.password = password;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
