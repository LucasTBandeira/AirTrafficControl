package com.grupotf.airtrafficControl.Dominio;

public class AeronaveCarga extends AeronaveComercial{

    private double peso_max;

    public AeronaveCarga(long id, String prefixo, double velocidade, double autonomia, String companhia,double peso_max) {
        super(id, prefixo, velocidade, autonomia, companhia);
        this.peso_max=peso_max;
    }

    public double getPeso_max() {
        return peso_max;
    }

    public void setPeso_max(double peso_max) {
        this.peso_max = peso_max;
    }

    @Override
    public String toString() {
        return "AeronaveComercialCarga [id=" + id + ", prefixo=" + prefixo + ", velocidade=" + velocidade + ", autonomia=" + autonomia
                +", companhia=" + companhia+", peso_max=" + peso_max+ "]";
    }
    
    
}
