package com.grupotf.airtrafficControl.Dominio;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("carga")
public class AeronaveCarga extends Aeronave{

    private double peso_max;
    private String companhia;

    public AeronaveCarga(long id, String prefixo, double velocidade, double autonomia, double peso_max,
            String companhia) {
        super(id, prefixo, velocidade, autonomia);
        this.peso_max = peso_max;
        this.companhia = companhia;
    }

    public double getPeso_max() {
        return peso_max;
    }

    public void setPeso_max(double peso_max) {
        this.peso_max = peso_max;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    @Override
    public String toString() {
        return "AeronaveComercialCarga [id=" + id + ", prefixo=" + prefixo + ", velocidade=" + velocidade + ", autonomia=" + autonomia
                +", companhia=" + companhia+", peso_max=" + peso_max+ "]";
    }
    
    
}
