package com.jozxi.petbeat.Objetos;

/**
 * Created by jsara on 27/02/2017.
 */

public class NodeMcu {

    double heartBeat;
    double temperature;
    String id;
    boolean qs;


    public NodeMcu() {
    }

    public NodeMcu(double heartBeat, double temperature, String id, boolean qs) {
        this.heartBeat = heartBeat;
        this.temperature = temperature;
        this.id = id;
        this.qs = qs;
    }

    public double getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(double heartBeat) {
        this.heartBeat = heartBeat;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isQs() {
        return qs;
    }

    public void setQs(boolean qs) {
        this.qs = qs;
    }
}
