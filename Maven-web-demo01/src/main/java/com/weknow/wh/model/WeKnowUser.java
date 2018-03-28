package com.weknow.wh.model;

public class WeKnowUser {
    private String wkuserid;

    private String username;

    private String userpassword;

    private String wkcode;

    private String usermail;

    public String getWkuserid() {
        return wkuserid;
    }

    public void setWkuserid(String wkuserid) {
        this.wkuserid = wkuserid == null ? null : wkuserid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getWkcode() {
        return wkcode;
    }

    public void setWkcode(String wkcode) {
        this.wkcode = wkcode == null ? null : wkcode.trim();
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail == null ? null : usermail.trim();
    }
}