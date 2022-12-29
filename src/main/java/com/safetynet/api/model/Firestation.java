package com.safetynet.api.model;

public class Firestation {

    private String address;
    private int station;

    //Constructor
    public Firestation() {
        super();
        // TODO Auto-generated constructor stub
    }

    //Getters & setters
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getStation() {
        return station;
    }
    public void setStation(int station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Firestation{" +
                " address='" + address + '\'' +
                " station='" + station + '\'' +
                '}';
    }

}
