package com.reservasi.model;

public class Instructor{
    private int instructorId;
    private String nama;
    private String email;
    private String phoneNumber;
    private String specialization;

    public Instructor(int instructorId, String nama, String email, String phoneNumber, String specialization){
        this.instructorId = instructorId; 
        this.nama = nama;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }
     public Instructor(String nama, String email, String phoneNumber, String specialization) {
        this.nama = nama;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }
    public int getInstructorId(){
        return instructorId;
    }
    public String getNama(){
        return nama;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getSpecialization(){
        return specialization;
    }
    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}