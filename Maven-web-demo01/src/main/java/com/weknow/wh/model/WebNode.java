package com.weknow.wh.model;

import java.util.Date;

public class WebNode {
    private String webnodeid;

    private String nodeweburl;

    private String nodeurl;

    private String nodename;

    private String nodecount;

    private Date nodetime;

    public String getWebnodeid() {
        return webnodeid;
    }

    public void setWebnodeid(String webnodeid) {
        this.webnodeid = webnodeid == null ? null : webnodeid.trim();
    }

    public String getNodeweburl() {
        return nodeweburl;
    }

    public void setNodeweburl(String nodeweburl) {
        this.nodeweburl = nodeweburl == null ? null : nodeweburl.trim();
    }

    public String getNodeurl() {
        return nodeurl;
    }

    public void setNodeurl(String nodeurl) {
        this.nodeurl = nodeurl == null ? null : nodeurl.trim();
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename == null ? null : nodename.trim();
    }

    public String getNodecount() {
        return nodecount;
    }

    public void setNodecount(String nodecount) {
        this.nodecount = nodecount == null ? null : nodecount.trim();
    }

    public Date getNodetime() {
        return nodetime;
    }

    public void setNodetime(Date nodetime) {
        this.nodetime = nodetime;
    }
}