package com.mobin.entity;

public class User {
    private String userID;
    private String secretKey;
    private String userName;
    private String passWord;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", secrestKey='" + secretKey + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                '}';
    }
}
