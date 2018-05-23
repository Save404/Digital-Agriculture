package com.domain;

public class Province {
    private String id;
    private String codeP;
    private String nameP;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Province{" +
                "id='" + id + '\'' +
                ", codeP='" + codeP + '\'' +
                ", nameP='" + nameP + '\'' +
                '}';
    }
}
