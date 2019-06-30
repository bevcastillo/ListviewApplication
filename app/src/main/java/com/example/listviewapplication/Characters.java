package com.example.listviewapplication;

public class Characters {

    private int img;
    private String name, course;

    //constructor
    public Characters(int img, String name, String course) {
        super();
        this.img = img;
        this.name = name;
        this.course = course;
    }

    //getters and setters


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
