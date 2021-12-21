package com.chosun.startupteamrecruitingapp;

import androidx.annotation.NonNull;

public class UploadFile {
    private String fileRealNm;
    private String fileStoredNm;
    private String filePath;
    private int fileSeq;
    private String fileType;
    private String deleteFlag;
    private String createDate;
    private String modifyDate;

    public UploadFile() {
        this.fileRealNm ="";
        fileStoredNm="";
        filePath="";
        fileSeq=0;
        fileType="";
        deleteFlag="";
        createDate="";
        modifyDate="";
    }

    public void setFileSeq(int fileSeq) {this.fileSeq = fileSeq;}
    public void setFileRealNm(String fileRealNm) {this.fileRealNm = fileRealNm; }
    public void setFileStoredNm(String fileStoredNm) {this.fileStoredNm = fileStoredNm; }
    public void setFilePath(String filePath) { this.filePath = filePath;}
    public void setFileType(String fileType) { this.fileType = fileType; }
    public void setDeleteFlag(String deleteFlag) { this.deleteFlag = deleteFlag; }
    public void setCreateDate(String createDate) { this.createDate = createDate; }
    public void setModifyDate(String modifyDate) { this.modifyDate = modifyDate; }
    public int getFileSeq() { return fileSeq; }
    public String getFileRealNm() { return fileRealNm; }
    public String getFileStoredNm() { return fileStoredNm; }
    public String getFilePath() { return filePath; }
    public String getFileType() { return fileType; }
    public String getDeleteFlag() { return deleteFlag; }
    public String getCreateDate() { return createDate; }
    public String getModifyDate() { return modifyDate; }

    @NonNull
    @Override
    public String toString() {
        return "{fileSeq='" + this.fileSeq + '\'' +
                ", fileRealNm='" + this.fileRealNm + '\'' +
                ", fileStoredNm='" + this.fileStoredNm + '\'' +
                ", filePath='" + this.filePath + '\'' +
                ", fileType='" + this.fileType + '\'' +
                ", deleteFlag='" + this.deleteFlag + '\'' +
                ", createDate='" + this.createDate + '\'' +
                ", modifyDate='" + this.modifyDate + '\'' +
                '}';
    }
}