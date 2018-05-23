package com.vo;

public class CPView {
    private String c1Code;
    private String c1Name;
    private String c2Code;
    private String c2Name;
    private String c3Code;
    private String c3Name;

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

    @Override
    public String toString() {
        return "CPView{" +
                "c1Code='" + c1Code + '\'' +
                ", c1Name='" + c1Name + '\'' +
                ", c2Code='" + c2Code + '\'' +
                ", c2Name='" + c2Name + '\'' +
                ", c3Code='" + c3Code + '\'' +
                ", c3Name='" + c3Name + '\'' +
                '}';
    }
}
