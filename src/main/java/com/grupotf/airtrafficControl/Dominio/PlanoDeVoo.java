package com.grupotf.airtrafficControl.Dominio;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PlanoDeVoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @ManyToOne
    private String prefixo;

    @ManyToOne
    private Rota rota;
    
    private int altitude;
    private String data;
    private int[] slots;
    
    protected PlanoDeVoo() {
    }

    public PlanoDeVoo(long id, String prefixo, Rota rota, int altitude, String data, int[] slots) {
        this.id = id;
        this.prefixo = prefixo;
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

    public String getAeronave() {
        return prefixo;
    }

    public void setAeronave(String prefixo) {
        this.prefixo = prefixo;
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
        return "PlanoDeVoo [id=" + id + ", aeronave=" + prefixo + ", rota=" + rota + ", altitude=" + altitude
                + ", data=" + data + ", slots=" + Arrays.toString(slots) + "]";
    }

    
    
}
