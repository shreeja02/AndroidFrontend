package com.example.dell.androidfrontend;

/**
 * Created by DELL on 6/5/2017.
 */

public class ansByQusIdClass {

    int answer_id;
    String answer;
    int fk_que_id;
    String fk_email_id;
    String date;
    String email_id;
    String user_name;
    String password;
    String user_photo;
    String mobile_no;
    String gender;

    public ansByQusIdClass(int answer_id, String answer, int fk_que_id, String fk_email_id, String date, String email_id, String user_name, String password, String user_photo, String mobile_no, String gender) {
        this.answer_id = answer_id;
        this.answer = answer;
        this.fk_que_id = fk_que_id;
        this.fk_email_id = fk_email_id;
        this.date = date;
        this.email_id = email_id;
        this.user_name = user_name;
        this.password = password;
        this.user_photo = user_photo;
        this.mobile_no = mobile_no;
        this.gender = gender;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getFk_que_id() {
        return fk_que_id;
    }

    public void setFk_que_id(int fk_que_id) {
        this.fk_que_id = fk_que_id;
    }

    public String getFk_email_id() {
        return fk_email_id;
    }

    public void setFk_email_id(String fk_email_id) {
        this.fk_email_id = fk_email_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
