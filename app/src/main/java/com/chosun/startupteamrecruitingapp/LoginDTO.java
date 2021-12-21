package com.chosun.startupteamrecruitingapp;

public class LoginDTO {
    private String memId;
    private String password;

    public LoginDTO(String memId, String password) {
        this.memId = memId;
        this.password = password;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemId() {
        return memId;
    }

    public String getPassword() {
        return password;
    }
}
