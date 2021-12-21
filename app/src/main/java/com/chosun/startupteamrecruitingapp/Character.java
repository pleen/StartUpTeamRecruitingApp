package com.chosun.startupteamrecruitingapp;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String memNickname;
    private int memSeq;
    private int univSeq;
    private int teamSeq;
    private String memMajor;
    private String memMbti;
    private UploadFile memProfileImage;
    private List<MemberPPLink> memPPLinks;
    private List<MemberAwards> memAwards;
    private List<Skill> memSkills;
    Character(){
        this.memNickname="";
        this.memSeq =0;
        this.univSeq=308;
        this.teamSeq=0;
        this.memMajor="";
        this.memMbti="";
        this.memProfileImage=new UploadFile();
        this.memPPLinks = new ArrayList<>();
        this.memAwards = new ArrayList<>();
        this.memSkills = new ArrayList<>();
    }
    public void setMemNickname(String memNickname) {this.memNickname = memNickname; }
    public void setMemSeq(int memSeq) {
        this.memSeq = memSeq;
    }
    public void setUnivSeq(int univSeq) {
        this.univSeq = univSeq;
    }
    public void setMemMajor(String memMajor) {
        this.memMajor = memMajor;
    }
    public void setMemMbti(String memMbti) {
        this.memMbti = memMbti;
    }
    public void setMemPPLinks(List<MemberPPLink> memPPLinks) {
        this.memPPLinks = memPPLinks;
    }
    public void setMemberAwards(List<MemberAwards> memAwards) {
        this.memAwards = memAwards;
    }
    public void setSkill(List<Skill> memSkills) {
        this.memSkills = memSkills;
    }
    public void setMemProfileImage(UploadFile memProfileImage) {
        this.memProfileImage = memProfileImage;
    }
    public void setTeamSeq(int teamSeq) {
        this.teamSeq = teamSeq;
    }
    public String getMemNickname() {
        return this.memNickname;
    }
    public int getMemSeq() {
        return this.memSeq;
    }
    public int getUnivSeq() {
        return univSeq;
    }
    public int getTeamSeq() {
        return teamSeq;
    }
    public String getMemMajor() {
        return this.memMajor;
    }
    public String getMemMbti() {
        return this.memMbti;
    }
    public List<MemberPPLink> getMemPPLinks() {return this.memPPLinks;}
    public List<MemberAwards> getMemberAwards() {return this.memAwards;}
    public List<Skill> getMemSkills() {return this.memSkills;}
    public UploadFile getMemProfileImage() {
        return memProfileImage;
    }
    @Override
    public String toString() {
        return "{memNickname='" + this.memNickname + '\'' +
                ", memSeq='" + this.memSeq + '\'' +
                ", univSeq='" + this.univSeq + '\'' +
                ", teamSeq='" + this.teamSeq + '\'' +
                ", memMajor='" + this.memMajor + '\'' +
                ", memMbti='" + this.memMbti + '\'' +
                ", memProfileImage='" + this.memProfileImage.toString() + '\'' +
                ", memPPLinks='" + this.memPPLinks.toString() + '\'' +
                ", memAwards='" + this.memAwards.toString() + '\'' +
                ", memSkills='" + this.memSkills.toString() + '\'' +
                '}';
    }
}