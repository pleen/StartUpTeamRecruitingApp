package com.chosun.startupteamrecruitingapp;

public class MemberPPLink {
    private int mplSeq;
    private int memSeq;
    private String mplContent;
    MemberPPLink(){
        this.mplSeq=0;
        this.memSeq=0;
        this.mplContent="";

    }
    public void setMplSeq(int mplSeq) {
        this.mplSeq = mplSeq;
    }
    public void setMemSeq(int memSeq) {
        this.memSeq = memSeq;
    }
    public void setMplContent(String mplContent) {
        this.mplContent = mplContent;
    }
    public int getMplSeq() {
        return this.mplSeq;
    }
    public int getMemSeq() {
        return this.memSeq;
    }
    public String getMplContent() {return this.mplContent;}

    @Override
    public String toString() {
        return  "{mplSeq='" + this.mplSeq + '\'' +
                ", memSeq='" + this.memSeq + '\'' +
                ", mplContent='" + this.mplContent + '\'' +
                '}';
    }
}