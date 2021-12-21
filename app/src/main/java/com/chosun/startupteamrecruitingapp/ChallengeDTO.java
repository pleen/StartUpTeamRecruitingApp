package com.chosun.startupteamrecruitingapp;

public class ChallengeDTO {
    private int cpt_seq;
    private String host;
    private String apply_way;
    private String qualifi;
    private String award_type;
    private String period;
    private String homepage;
    private int file_seq;
    private int field;
    private String file_stored_nm;
    private String file_path;
    private String title;

    public ChallengeDTO(int cpt_seq, String host, String apply_way, String qualifi, String award_type, String period, String homepage, int file_seq, int field, String file_stored_nm, String file_path, String title) {
        this.cpt_seq = cpt_seq;
        this.host = host;
        this.apply_way = apply_way;
        this.qualifi = qualifi;
        this.award_type = award_type;
        this.period = period;
        this.homepage = homepage;
        this.file_seq = file_seq;
        this.field = field;
        this.file_stored_nm = file_stored_nm;
        this.file_path = file_path;
        this.title = title;
    }

    public void setFile_stored_nm(String file_stored_nm) {
        this.file_stored_nm = file_stored_nm;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public void setCpt_seq(int cpt_seq) {
        this.cpt_seq = cpt_seq;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setApply_way(String apply_way) {
        this.apply_way = apply_way;
    }

    public void setQualifi(String qualifi) {
        this.qualifi = qualifi;
    }

    public void setAward_type(String award_type) {
        this.award_type = award_type;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setFile_seq(int file_seq) {
        this.file_seq = file_seq;
    }

    public void setField(int field) {
        this.field = field;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCpt_seq() {
        return cpt_seq;
    }

    public String getHost() {
        return host;
    }

    public String getFile_stored_nm() {
        return file_stored_nm;
    }

    public String getFile_path() {
        return file_path;
    }

    public String getApply_way() {
        return apply_way;
    }

    public String getQualifi() {
        return qualifi;
    }

    public String getAward_type() {
        return award_type;
    }

    public String getPeriod() {
        return period;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getFile_seq() {
        return file_seq;
    }

    public int getField() {
        return field;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ChallengeDTO{" +
                "cpt_seq=" + cpt_seq +
                ", host='" + host + '\'' +
                ", apply_way='" + apply_way + '\'' +
                ", qualifi='" + qualifi + '\'' +
                ", award_type='" + award_type + '\'' +
                ", period='" + period + '\'' +
                ", homepage='" + homepage + '\'' +
                ", file_seq=" + file_seq +
                ", field=" + field +
                ", title='" + title + '\'' +
                '}';
    }
}
