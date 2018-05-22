package com.domain;

public class Category2 {
    private Long c2Id;
    private String c2Code;
    private String c2Name;
    private String f2Code;

    public Long getC2Id() {
        return c2Id;
    }

    public void setC2Id(Long c2Id) {
        this.c2Id = c2Id;
    }

    public String getC2Code() {
        return c2Code;
    }

    public void setC2Code(String c2Code) {
        this.c2Code = c2Code;
    }

    public String getC2Name() {
        return c2Name;
    }

    public void setC2Name(String c2Name) {
        this.c2Name = c2Name;
    }

    public String getF2Code() {
        return f2Code;
    }

    public void setF2Code(String f2Code) {
        this.f2Code = f2Code;
    }

    @Override
    public String toString() {
        return "Category2{" +
                "c2Id=" + c2Id +
                ", c2Code='" + c2Code + '\'' +
                ", c2Name='" + c2Name + '\'' +
                ", f2Code='" + f2Code + '\'' +
                '}';
    }
}
