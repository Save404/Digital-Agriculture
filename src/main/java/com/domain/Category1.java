package com.domain;

public class Category1 {
    private Long c1Id;
    private String c1Code;
    private String c1Name;

    public Long getC1Id() {
        return c1Id;
    }

    public void setC1Id(Long c1Id) {
        this.c1Id = c1Id;
    }

    public String getC1Code() {
        return c1Code;
    }

    public void setC1Code(String c1Code) {
        this.c1Code = c1Code;
    }

    public String getC1Name() {
        return c1Name;
    }

    public void setC1Name(String c1Name) {
        this.c1Name = c1Name;
    }

    @Override
    public String toString() {
        return "Category1{" +
                "c1Id=" + c1Id +
                ", c1Code='" + c1Code + '\'' +
                ", c1Name='" + c1Name + '\'' +
                '}';
    }
}
