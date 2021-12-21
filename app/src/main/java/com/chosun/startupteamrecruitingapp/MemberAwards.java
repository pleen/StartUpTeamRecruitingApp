package com.chosun.startupteamrecruitingapp;

import java.io.Serializable;

public class MemberAwards implements Serializable {
    private int awardSeq;
    private int memSeq;
    private String awardContent;
    private String awardTime;
    MemberAwards() {
        this.awardSeq=0;
        this.memSeq=0;
        this.awardContent="";
        this.awardTime="";
    }
    public void setAwardSeq(int awardSeq) {
        this.awardSeq = awardSeq;
    }
    public void setMemSeq(int memSeq) {
        this.memSeq = memSeq;
    }
    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }
    public void setAwardTime(String awardTime) {
        this.awardTime = awardTime;
    }
    public int getAwardSeq() {
        return this.awardSeq;
    }
    public int getMemSeq() {
        return this.memSeq;
    }
    public String getAwardContent() {
        return this.awardContent;
    }
    public String getAwardTime() {
        return this.awardTime;
    }

    @Override
    public String toString() {
        return  "{awardSeq='" + this.awardSeq + '\'' +
                ", memSeq='" + this.memSeq + '\'' +
                ", awardContent='" + this.awardContent + '\'' +
                ", awardTime='" + this.awardTime + '\'' +
                '}';
    }
}