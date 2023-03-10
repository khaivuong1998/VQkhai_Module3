package com.example.ss10_jsp_jstl_bai_tap;

public class Student {
    private Integer id;
    private String name;
    private Integer gender;
    private Double score;
    private String img;

    public Student() {
    }

    public Student(Integer id, String name, Integer gender, Double score, String img) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score = score;
        this.img = img;
    }

    public Student(Integer id, String name, Integer gender, String img) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
