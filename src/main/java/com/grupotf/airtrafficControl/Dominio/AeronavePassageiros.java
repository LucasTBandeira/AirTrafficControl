package com.grupotf.airtrafficControl.Dominio;

import jakarta.persistence.Entity;

@Entity
public class AeronavePassageiros extends AeronaveComercial {

    private int n_passageiros;
    public AeronavePassageiros(long id, String prefixo, double velocidade, double autonomia, String companhia,int n_passageiros) {
        super(id, prefixo, velocidade, autonomia, companhia);
        this.n_passageiros=n_passageiros;
    }
    public int getN_passageiros() {
        return n_passageiros;
    }
    public void setN_passageiros(int n_passageiros) {
        this.n_passageiros = n_passageiros;
    }
    @Override
    public String toString() {
         return "AeronaveComercialPassageiros [id=" + id + ", prefixo=" + prefixo + ", velocidade=" + velocidade + ", autonomia=" + autonomia
                +", companhia=" + companhia+ ", n_passageiros=" + n_passageiros+"]";
    }
    
    
}
