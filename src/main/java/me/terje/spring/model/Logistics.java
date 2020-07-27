package me.terje.spring.model;

import java.io.Serializable;

public class Logistics implements Serializable{
    private int id;
    private int orderId;
    private String companyName;
    private String startCity;
    private String targetCity;
    private int distance;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getTargetCity() {
        return targetCity;
    }

    public void setTargetCity(String targetCity) {
        this.targetCity = targetCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", companyName='" + companyName + '\'' +
                ", startCity='" + startCity + '\'' +
                ", targetCity='" + targetCity + '\'' +
                ", distance=" + distance +
                '}';
    }
}
