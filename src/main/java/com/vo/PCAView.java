package com.vo;

public class PCAView {
    private String codeP;
    private String nameP;
    private String codeC;
    private String nameC;
    private String codeA;
    private String nameA;

    public String getCodeP() {
        return codeP;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getCodeC() {
        return codeC;
    }

    public void setCodeC(String codeC) {
        this.codeC = codeC;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getCodeA() {
        return codeA;
    }

    public void setCodeA(String codeA) {
        this.codeA = codeA;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    @Override
    public String toString() {
        return "PCAView{" +
                "codeP='" + codeP + '\'' +
                ", nameP='" + nameP + '\'' +
                ", codeC='" + codeC + '\'' +
                ", nameC='" + nameC + '\'' +
                ", codeA='" + codeA + '\'' +
                ", nameA='" + nameA + '\'' +
                '}';
    }
}
