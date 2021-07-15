package com.nagarro.training.SearchFlight;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class flightdata {
    private int id;

    private String FLIGHT_NO;

    private String DEP_LOC;

    private String ARR_LOC;

    private String VALID_TILL;

    private String FLIGHT_TIME;

    private String FLIGHT_DUR;

    private String FARE;

    private String SEAT_AVAILABILITY;

    private String CLASS;

    public flightdata() {
        super();
    }

    public flightdata(String FLIGHT_NO, String DEP_LOC, String ARR_LOC, String VALID_TILL, String FLIGHT_TIME,
            String FLIGHT_DUR, String FARE, String SEAT_AVAILABILITY, String CLASS) {
        super();
        this.FLIGHT_NO = FLIGHT_NO;
        this.DEP_LOC = DEP_LOC;
        this.ARR_LOC = ARR_LOC;
        this.VALID_TILL = VALID_TILL;
        this.FLIGHT_TIME = FLIGHT_TIME;
        this.FLIGHT_DUR = FLIGHT_DUR;
        this.FARE = FARE;
        this.SEAT_AVAILABILITY = SEAT_AVAILABILITY;
        this.CLASS = CLASS;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFLIGHT_NO() {
        return FLIGHT_NO;
    }

    public void setFLIGHT_NO(String fLIGHT_NO) {
        FLIGHT_NO = fLIGHT_NO;
    }

    public String getDEP_LOC() {
        return DEP_LOC;
    }

    public void setDEP_LOC(String dEP_LOC) {
        DEP_LOC = dEP_LOC;
    }

    public String getARR_LOC() {
        return ARR_LOC;
    }

    public void setARR_LOC(String aRR_LOC) {
        ARR_LOC = aRR_LOC;
    }

    public String getVALID_TILL() {
        return VALID_TILL;
    }

    public void setVALID_TILL(String vALID_TILL) {
        VALID_TILL = vALID_TILL;
    }

    public String getFLIGHT_TIME() {
        return FLIGHT_TIME;
    }

    public void setFLIGHT_TIME(String fLIGHT_TIME) {
        FLIGHT_TIME = fLIGHT_TIME;
    }

    public String getFLIGHT_DUR() {
        return FLIGHT_DUR;
    }

    public void setFLIGHT_DUR(String fLIGHT_DUR) {
        FLIGHT_DUR = fLIGHT_DUR;
    }

    public String getFARE() {
        return FARE;
    }

    public void setFARE(String fARE) {
        FARE = fARE;
    }

    public String getSEAT_AVAILABILITY() {
        return SEAT_AVAILABILITY;
    }

    public void setSEAT_AVAILABILITY(String sEAT_AVAILABILITY) {
        SEAT_AVAILABILITY = sEAT_AVAILABILITY;
    }

    public String getCLASS() {
        return CLASS;
    }

    public void setCLASS(String cLASS) {
        CLASS = cLASS;
    }
}