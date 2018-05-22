package com.domain;

public class Category3 {
    private Long c3Id;
    private String c3Code;
    private String c3Name;
    private String f3Code;

    public Long getC3Id() {
        return c3Id;
    }

    public void setC3Id(Long c3Id) {
        this.c3Id = c3Id;
    }

    public String getC3Code() {
        return c3Code;
    }

    public void setC3Code(String c3Code) {
        this.c3Code = c3Code;
    }

    public String getC3Name() {
        return c3Name;
    }

    public void setC3Name(String c3Name) {
        this.c3Name = c3Name;
    }

    public String getF3Code() {
        return f3Code;
    }

    public void setF3Code(String f3Code) {
        this.f3Code = f3Code;
    }

    @Override
    public String toString() {
        return "Category3{" +
                "c3Id=" + c3Id +
                ", c3Code='" + c3Code + '\'' +
                ", c3Name='" + c3Name + '\'' +
                ", f3Code='" + f3Code + '\'' +
                '}';
    }
}
