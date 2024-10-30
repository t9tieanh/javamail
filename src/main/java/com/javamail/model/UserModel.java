package com.javamail.model;

public class UserModel {
    private int id;
    private String email;
    private String firstName;
    private String lastName;

    public UserModel(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public UserModel() {}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmailContent () {
        return String.format("Xin chào %s %s\n Đây là email xác nhận việc bạn đã nhấn đăng ký ở trang web https://t9tieanh.github.io/tieanh19-infomation chúng tôi!"
                , firstName, lastName);
    }
    public String getEmailTitle () {
        return String.format("XIN CHÀO %s %s", firstName, lastName);
    }
}
