package com.ohgiraffers.sessionsecurity.user.model.dto;



public class SignupDTO {

    private String userId;
    private String userName;
    private String userPass;
    private String role;

    public SignupDTO() {
    }

    public SignupDTO(String userId, String userName, String userPass, String role) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SignupDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
