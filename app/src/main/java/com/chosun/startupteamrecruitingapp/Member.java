package com.chosun.startupteamrecruitingapp;

import java.io.Serializable;

public class Member implements Serializable {
    private String memId;
    private String password;
    private String memNm;
    private String introduce;
    private String memEmail;
    private String memStat;
    private String memPhone;
    private String createDate;
    private String memType;
    private Character character;

    Member(){
        this.memId="";
        this.password="";
        this.memNm="";
        this.introduce="";
        this.memEmail="";
        this.memStat="";
        this.memPhone="";
        this.memType="";
        this.character=new Character();
        this.createDate="";
    }
    public void setMemId(String memId) {
        this.memId = memId;
    }
    public void setPassword(String password) {this.password = password;}
    public void setMemNm(String memNm) {
        this.memNm = memNm;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }
    public void setMemStat(String memStat) {
        this.memStat = memStat;
    }
    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }
    public void setMemType(String memType) {
        this.memType = memType;
    }
    public void setCharacter(Character character) { this.character = character; }
    public void setCreateDate(String createDate) {this.createDate = createDate;}
    public String getMemId() {
        return this.memId;
    }
    public String getPassword() {return this.password;}
    public String getMemNm() {
        return this.memNm;
    }
    public String getIntroduce() {
        return this.introduce;
    }
    public String getMemEmail() {
        return this.memEmail;
    }
    public String getMemStat() {
        return this.memStat;
    }
    public String getMemPhone() {
        return this.memPhone;
    }
    public String getMemType() {
        return this.memType;
    }
    public Character getCharacter() { return this.character; }
    public String getCreateDate() {return this.createDate;}
    @Override
    public String toString() {
        return "Member{" +
                "memId='" + this.memId + '\'' +
                ", password='" + this.password + '\'' +
                ", memNm='" + this.memNm + '\'' +
                ", introduce='" + this.introduce + '\'' +
                ", memEmail='" + this.memEmail + '\'' +
                ", memStat='" + this.memStat + '\'' +
                ", memPhone='" + this.memPhone + '\'' +
                ", memType='" + this.memType + '\'' +
                ", character='" + this.character.toString() + '\'' +
                ", createDate='" + this.createDate + '\'' +
                '}';
    }
}