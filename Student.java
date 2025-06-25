package com.reservasi.model;

public class Student{
    private int studentId;
    private String nama;
    private String email;
    private String phoneNumber;

    public Student(int studentId, String nama, String email, String phoneNumber){
        this.studentId = studentId;
        this.nama = nama;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student(String nama, String email, String phoneNumber){
        this.nama = nama;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getStudentId(){
        return studentId;
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

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setEmail(String email){
        this.email = email;    
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }    
}