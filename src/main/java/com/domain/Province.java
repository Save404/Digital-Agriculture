package com.domain;

public class Province {
    private String id;
    private String codeP;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id='" + id + '\'' +
                ", codeP='" + codeP + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
