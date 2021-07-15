package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class spring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String flightNo;
    private String delLoc;
    private String arrLoc;
    private String validTill;
    private String flightDur;
    private String flightTime;
    private String fare;
    private String seatAvail;
    private String class1;
    private String outPref;
    public spring() {
        super();
        // spring Auto-generated constructor stub
    }
    public spring(int id, String flightNo, String delLoc, String arrLoc, String validTill, String flightTime,
            String flightDur, String fare, String seatAvail, String class1, String outPref) {
        super();
        this.id = id;
        this.flightNo = flightNo;
        this.delLoc = delLoc;
        this.arrLoc = arrLoc;
        this.validTill = validTill;
        this.flightDur = flightDur;
        this.fare = fare;
        this.seatAvail = seatAvail;
        this.class1 = class1;
        this.outPref = outPref;
        this.flightTime=flightTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFlightNo() {
        return flightNo;
    }
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }
    public String getDelLoc() {
        return delLoc;
    }
    public void setDelLoc(String delLoc) {
        this.delLoc = delLoc;
    }
    public String getArrLoc() {
        return arrLoc;
    }
    public void setArrLoc(String arrLoc) {
        this.arrLoc = arrLoc;
    }
    public String getValidTill() {
        return validTill;
    }
    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }
    public String getFlightDur() {
        return flightDur;
    }
    public void setFlightDur(String flightDur) {
        this.flightDur = flightDur;
    }
    public String getFare() {
        return fare;
    }
    public void setFare(String fare) {
        this.fare = fare;
    }
    public String getSeatAvail() {
        return seatAvail;
    }
    public void setSeatAvail(String seatAvail) {
        this.seatAvail = seatAvail;
    }
    public String getClass1() {
        return class1;
    }
    public void setClass1(String class1) {
        this.class1 = class1;
    }
    public String getOutPref() {
        return outPref;
    }
    public void setOutPref(String outPref) {
        this.outPref = outPref;
    }
    public String getFlightTime() {
        return flightTime;
    }
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    
}
    
    
