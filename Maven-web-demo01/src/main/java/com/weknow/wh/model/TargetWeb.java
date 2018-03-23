package com.weknow.wh.model;

public class TargetWeb {
    private String tarid;

    private String tarurl;

    private String tarname;

    public String getTarid() {
        return tarid;
    }

    public void setTarid(String tarid) {
        this.tarid = tarid == null ? null : tarid.trim();
    }

    public String getTarurl() {
        return tarurl;
    }

    public void setTarurl(String tarurl) {
        this.tarurl = tarurl == null ? null : tarurl.trim();
    }

    public String getTarname() {
        return tarname;
    }

    public void setTarname(String tarname) {
        this.tarname = tarname == null ? null : tarname.trim();
    }
}