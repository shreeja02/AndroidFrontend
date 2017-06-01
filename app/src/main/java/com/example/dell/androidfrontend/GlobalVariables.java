package com.example.dell.androidfrontend;

/**
 * Created by Meet on 01-Jun-17.
 */

public class GlobalVariables {


     static String email_id = null;

    public GlobalVariables(String email_id) {
        this.email_id = email_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
