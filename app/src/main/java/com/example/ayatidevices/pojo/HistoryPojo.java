package com.example.ayatidevices.pojo;

public class HistoryPojo {
    private String name;
    private String dob;
    private int imgId;

    public HistoryPojo(String name, String dob,int imgId) {
        this.name = name;
        this.dob = dob;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
