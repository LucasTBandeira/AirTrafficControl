package com.grupotf.airtrafficControl.Dominio;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("passageiros")
public class AeronavePassageiros extends Aeronave {

    private int n_passageiros;
    private String companhia;

    public AeronavePassageiros(long id, String prefixo, double velocidade, double autonomia, int n_passageiros,
            String companhia) {
        super(id, prefixo, velocidade, autonomia);
        this.n_passageiros = n_passageiros;
        this.companhia = companhia;
    }

    protected AeronavePassageiros(){}
    
    public int getN_passageiros() {
        return n_passageiros;
    }

    public void setN_passageiros(int n_passageiros) {
        this.n_passageiros = n_passageiros;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    @Override
    public String toString() {
         return "AeronaveComercialPassageiros [id=" + id + ", prefixo=" + prefixo + ", velocidade=" + velocidade + ", autonomia=" + autonomia
                +", companhia=" + companhia+ ", n_passageiros=" + n_passageiros+"]";
    }
    
    
}
