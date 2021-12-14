package com.chosun.startupteamrecruitingapp;

public class University {
    // @SerializedName()로 변수명을 입치시켜주면 클래스 변수명이 달라도 알아서 매핑시켜줌
    private int univSeq;
    private String univNm;
    private String univDomain;

    public void setUnivSeq(int univSeq) {
        this.univSeq = univSeq;
    }

    public void setUnivNm(String univNm) {
        this.univNm = univNm;
    }

    public void setUnivDomain(String univDomain) {
        this.univDomain = univDomain;
    }

    public int getUnivSeq() {
        return univSeq;
    }

    public String getUnivNm() {
        return univNm;
    }

    public String getUnivDomain() {
        return univDomain;
    }

    @Override
    public String toString() {
        return "University{" +
                "univSeq=" + univSeq +
                ", univNm='" + univNm + '\'' +
                ", univDomain='" + univDomain + '\'' +
                '}';
    }
}
