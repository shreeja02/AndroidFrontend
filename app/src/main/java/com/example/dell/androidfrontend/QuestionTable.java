package com.example.dell.androidfrontend;

/**
 * Created by Meet on 05-Jun-17.
 */

public class QuestionTable {

    int question_id;
    String question_title;
    String question_desc;
    int fk_category_id;
    String date;
    String apporve;
    String fk_email_id;
    String user_name;
    String user_photo;
    String category_name;
    int category_id;

    public QuestionTable(int question_id, String question_title, String question_desc, int fk_category_id, String date, String apporve, String fk_email_id, String user_name, String user_photo, String category_name, int category_id) {
        this.question_id = question_id;
        this.question_title = question_title;
        this.question_desc = question_desc;
        this.fk_category_id = fk_category_id;
        this.date = date;
        this.apporve = apporve;
        this.fk_email_id = fk_email_id;
        this.user_name = user_name;
        this.user_photo = user_photo;
        this.category_name = category_name;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getQuestion_desc() {
        return question_desc;
    }

    public void setQuestion_desc(String question_desc) {
        this.question_desc = question_desc;
    }

    public int getFk_category_id() {
        return fk_category_id;
    }

    public void setFk_category_id(int fk_category_id) {
        this.fk_category_id = fk_category_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getApporve() {
        return apporve;
    }

    public void setApporve(String apporve) {
        this.apporve = apporve;
    }

    public String getFk_email_id() {
        return fk_email_id;
    }

    public void setFk_email_id(String fk_email_id) {
        this.fk_email_id = fk_email_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
