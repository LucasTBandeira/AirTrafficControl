package com.grupotf.airtrafficControl.Dominio;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;

@Entity
public class AeronaveComercial extends Aeronave{

    protected String companhia;

    public AeronaveComercial(long id, String prefixo, double velocidade, double autonomia,String companhia) {
        super(id, prefixo, velocidade, autonomia);
        this.companhia=companhia;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    @Override
    public String toString() {
        return "AeronaveComercial [id=" + id + ", prefixo=" + prefixo + ", velocidade=" + velocidade + ", autonomia=" + autonomia
                +", companhia=" + companhia+ "]";
    }

    
    
}
