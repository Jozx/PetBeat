package com.jozxi.petbeat.Objetos;

/**
 * Created by jsara on 27/02/2017.
 */

public class NodeMcu {

    double heartBeat;
    double obj_temperature;
    double amb_temperature;
    String id;
    boolean qs;


    public NodeMcu() {
    }

    public NodeMcu(double heartBeat, double obj_temperature, double amb_temperature, String id, boolean qs) {
        this.heartBeat = heartBeat;
        this.obj_temperature = obj_temperature;
        this.amb_temperature = amb_temperature;
        this.id = id;
        this.qs = qs;
    }

    public double getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(double heartBeat) {
        this.heartBeat = heartBeat;
    }

    public double getObj_temperature() {
        return obj_temperature;
    }

    public void setObj_temperature(double obj_temperature) {
        this.obj_temperature = obj_temperature;
    }

    public double getAmb_temperature() {
        return amb_temperature;
    }

    public void setAmb_temperature(double amb_temperature) {
        this.amb_temperature = amb_temperature;
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
