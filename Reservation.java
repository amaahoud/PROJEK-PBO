package com.reservasi.model;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;

public class Reservation {

    private int reservationId;
    private int studentId;
    private int courseId;
    private int instructorId;
    private Date reservationDate;
    private Time reservationTime;
    private String status;
    private Timestamp createdAt;

    public Reservation(int reservationId, int studentId, int courseId, int instructorId, Date reservationDate, Time reservaTime, String status, Timestamp createdAt, Time reservationTime){
        this.reservationId = reservationId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.instructorId = instructorId;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.status = status;
        this.createdAt = createdAt;
    }
    public Reservation(int studentId, int courseId, int instructorId, Date reservationDate, Time reservationTime, String status){
        this.studentId = studentId;
        this.courseId =  courseId;
        this.instructorId = instructorId;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.status = status;   
    }
    public int getReservation(){
        return reservationId;
    }
    public int getStudentId(){
        return studentId;
    }
    public int getCourseId(){
        return courseId;
    }
    public int getInstructorId(){
        return instructorId;
    }
    public Date getReservationDate(){
        return reservationDate;
    }
    public Time getReservationTime(){
        return reservationTime;
    }
    public String getStatus(){
        return status;
    }
    public Timestamp getCreatedAt(){
        return createdAt;
    }
    public void setReservationId(int reservationId){
        this.reservationId = reservationId;
    }
     public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setReservationTime(Time reservationTime) {
        this.reservationTime = reservationTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}