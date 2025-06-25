package com.reservasi.model;

public class Course{
    private int courseId;
    private String courseNama;
    private String description;
    private double price;
    private int durationHours;

    public Course(int courseId, String coursNama,String description, double price, int durationHours){
        this.courseId = courseId;
        this.courseNama = coursNama;
        this.description = description;
        this.price = price;
        this.durationHours = durationHours;
    }
    public Course(String coursNama, String description, double price, int durationHours, String courseNama){
        this.courseNama = courseNama;
        this.description = description;
        this.price = price;
        this.durationHours = durationHours;
    }
    public int getCourseId(){
        return courseId;
    }
    public String getCourseNama(){
        return courseNama;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }
    public int getDurationHours(){
        return durationHours;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseNama) {
        this.courseNama = courseNama;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }
}