package com.grupotf.airtrafficControl.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aeronave {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected String prefixo;
    protected double velocidade;
    protected double autonomia;

    protected Aeronave() {
    }

    public Aeronave(long id, String prefixo, double velocidade, double autonomia) {
        this.id = id;
        this.prefixo = prefixo;
        this.velocidade = velocidade;
        this.autonomia = autonomia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

  

    

    
}
