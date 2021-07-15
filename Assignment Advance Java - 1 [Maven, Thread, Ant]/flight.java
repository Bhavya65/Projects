package com.nagarro.training.SearchFlight;

import com.opencsv.bean.CsvBindByName;

public class flight {

    @CsvBindByName
    private String FLIGHT_NO;

    @CsvBindByName
    private String DEP_LOC;

    @CsvBindByName
    private String ARR_LOC;

    @CsvBindByName
    private String VALID_TILL;

    @CsvBindByName
    private String FLIGHT_TIME;

    @CsvBindByName
    private String FLIGHT_DUR;

    @CsvBindByName
    private String FARE;

    @CsvBindByName
    private String SEAT_AVAILABILITY;

    @CsvBindByName
    private String CLASS;

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