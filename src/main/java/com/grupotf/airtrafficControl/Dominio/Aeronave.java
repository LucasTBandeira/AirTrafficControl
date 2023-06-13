package com.grupotf.airtrafficControl.Dominio;

public class Aeronave {
    protected long id;
    protected String prefixo;
    protected double velocidade;
    protected double autonomia;

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
