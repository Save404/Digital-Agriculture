package com.domain;

public class Category3 {
    private Long cid;
    private String ccode;
    private String cname;
    private String fcode;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    @Override
    public String toString() {
        return "Category3{" +
                "cid=" + cid +
                ", ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                ", fcode='" + fcode + '\'' +
                '}';
    }
}
