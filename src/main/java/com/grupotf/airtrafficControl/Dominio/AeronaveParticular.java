package com.grupotf.airtrafficControl.Dominio;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("particular")
public class AeronaveParticular extends Aeronave {

    private String empresa;
    public AeronaveParticular(long id, String prefixo, double velocidade, double autonomia,String empresa) {
        super(id, prefixo, velocidade, autonomia);
        this.empresa=empresa;
        
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "AeronaveParticular [id=" + id + ", prefixo=" + prefixo + ", velocidade=" + velocidade + ", autonomia=" + autonomia
                + ", empresa=" +empresa+"]";
    }
    
}
