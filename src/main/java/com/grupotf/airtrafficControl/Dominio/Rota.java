package com.grupotf.airtrafficControl.Dominio;

public class Rota {
    private long id; 
    private String nome;
    private String aero_Origem;
    private String aero_Destino;
    private double distancia;

    public Rota(long id, String nome, String aero_Origem, String aero_Destino, double distancia) {
        this.id = id;
        this.nome = nome;
        this.aero_Origem = aero_Origem;
        this.aero_Destino = aero_Destino;
        this.distancia = distancia;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAero_Origem() {
        return aero_Origem;
    }
    public void setAero_Origem(String aero_Origem) {
        this.aero_Origem = aero_Origem;
    }
    public String getAero_Destino() {
        return aero_Destino;
    }
    public void setAero_Destino(String aero_Destino) {
        this.aero_Destino = aero_Destino;
    }
    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    @Override
    public String toString() {
        return "Rota [id=" + id + ", nome=" + nome + ", aero_Origem=" + aero_Origem + ", aero_Destino=" + aero_Destino
                + ", distancia=" + distancia + "]";
    }

    
}
