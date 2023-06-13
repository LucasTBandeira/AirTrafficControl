package com.grupotf.airtrafficControl.Dominio;

import java.util.Arrays;

public class PlanoDeVoo {
    private long id;
    private Aeronave aeronave;
    private Rota rota;
    private int altitude;
    private String data;
    private int[] slots;
    
    public PlanoDeVoo(long id, Aeronave aeronave, Rota rota, int altitude, String data, int[] slots) {
        this.id = id;
        this.aeronave = aeronave;
        this.rota = rota;
        this.altitude = altitude;
        this.data = data;
        this.slots = slots;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int[] getSlots() {
        return slots;
    }

    public void setSlots(int[] slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "PlanoDeVoo [id=" + id + ", aeronave=" + aeronave + ", rota=" + rota + ", altitude=" + altitude
                + ", data=" + data + ", slots=" + Arrays.toString(slots) + "]";
    }

    
    
}
