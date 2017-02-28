package com.jozxi.petbeat.Objetos;

/**
 * Created by jsara on 27/02/2017.
 */

public class NodeMcu {
    int heartBeat;
    boolean qs;


    public NodeMcu() {
    }

    public NodeMcu(int heartBeat, boolean qs) {
        this.heartBeat = heartBeat;
        this.qs = qs;
    }

    public int getHeartBeat() {
        return heartBeat;
    }

    public boolean isQs() {
        return qs;
    }
}
