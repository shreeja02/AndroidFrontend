package com.example.dell.androidfrontend;

/**
 * Created by Kosha on 31-05-2017.
 */

public class User {
    String email_id;
    String user_name;
    String password;
    String user_photo;
    String mobile_no;
    String gender;

    public User(String email_id, String user_name, String password, String user_photo, String mobile_no, String gender) {
        this.email_id = email_id;
        this.user_name = user_name;
        this.password = password;
        this.user_photo = user_photo;
        this.mobile_no = mobile_no;
        this.gender = gender;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
