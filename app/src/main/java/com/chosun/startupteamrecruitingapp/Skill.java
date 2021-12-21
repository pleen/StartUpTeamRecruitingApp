package com.chosun.startupteamrecruitingapp;

public class Skill {
    private int skillSeq;
    private String skillNm;
    private String skillClassification;
    private String fileSeq;
    Skill() {
        this.skillSeq=1;
        this.skillNm="";
        this.skillClassification="";
        this.fileSeq="";
    }
    public void setSkillSeq(int skillSeq) {
        this.skillSeq = skillSeq;
    }
    public void setSkillNm(String skillNm) {
        this.skillNm = skillNm;
    }
    public void setSkillClassification(String skillClassification) {this.skillClassification = skillClassification;}
    public void setFileSeq(String fileSeq) {
        this.fileSeq = fileSeq;
    }
    public int getSkillSeq() {
        return this.skillSeq;
    }
    public String getSkillNm() {
        return this.skillNm;
    }
    public String getSkillClassification() {
        return this.skillClassification;
    }
    public String getFileSeq() {
        return this.fileSeq;
    }

    @Override
    public String toString() {
        return "{skillSeq=" + this.skillSeq + '\'' +
                ", skillNm='" + this.skillNm + '\'' +
                ", skillClassification='" + this.skillClassification + '\'' +
                ", fileSeq='" + this.fileSeq + '\'' +
                '}';
    }
}