package com.domain;

public class Area {
    private String id;
    private String codeA;
    private String nameA;
    private String codeC;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCodeC() {
        return codeC;
    }

    public void setCodeC(String codeC) {
        this.codeC = codeC;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id='" + id + '\'' +
                ", codeA='" + codeA + '\'' +
                ", nameA='" + nameA + '\'' +
                ", codeC='" + codeC + '\'' +
                '}';
    }
}
