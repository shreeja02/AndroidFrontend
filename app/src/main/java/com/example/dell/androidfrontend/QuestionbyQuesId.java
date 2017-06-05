package com.example.dell.androidfrontend;

/**
 * Created by Kosha on 01-06-2017.
 */

public class QuestionbyQuesId {

    Integer question_id;
    String question_title;
    String question_desc;
    Integer fk_category_id;
    String date;
    String apporve;
    String fk_email_id;
    String user_name;



    public QuestionbyQuesId(Integer question_id, String question_title, String question_desc, Integer fk_category_id, String date, String apporve, String fk_email_id, String user_name) {
        this.question_id = question_id;
        this.question_title = question_title;
        this.question_desc = question_desc;
        this.fk_category_id = fk_category_id;
        this.date = date;
        this.apporve = apporve;
        this.fk_email_id = fk_email_id;
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
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

    public Integer getFk_category_id() {
        return fk_category_id;
    }

    public void setFk_category_id(Integer fk_category_id) {
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
}
