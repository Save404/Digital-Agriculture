package com.domain;

public class Category1 {
    private Long cid;
    private String ccode;
    private String cname;

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

    @Override
    public String toString() {
        return "Category1{" +
                "cid=" + cid +
                ", ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
