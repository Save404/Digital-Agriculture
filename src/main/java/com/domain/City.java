package com.domain;

public class City {
    private String id;
    private String codeC;
    private String nameC;
    private String codeP;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCodeP() {
        return codeP;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", codeC='" + codeC + '\'' +
                ", nameC='" + nameC + '\'' +
                ", codeP='" + codeP + '\'' +
                '}';
    }
}
