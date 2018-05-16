package com.domain;

public class Product {
    private Long pid;
    private String pcode;
    private String pname;
    private String fcode;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pcode='" + pcode + '\'' +
                ", pname='" + pname + '\'' +
                ", fcode='" + fcode + '\'' +
                '}';
    }
}
