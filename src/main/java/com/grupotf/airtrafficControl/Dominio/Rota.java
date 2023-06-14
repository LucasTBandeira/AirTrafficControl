package com.grupotf.airtrafficControl.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    private String nome;
    private String origem;
    private String destino;
    private double distancia;

    protected Rota() {
    }

    public Rota(long id, String nome, String origem, String destino, double distancia) {
        this.id = id;
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
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
    public String getorigem() {
        return origem;
    }
    public void setorigem(String origem) {
        this.origem = origem;
    }
    public String getdestino() {
        return destino;
    }
    public void setdestino(String destino) {
        this.destino = destino;
    }
    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    @Override
    public String toString() {
        return "Rota [id=" + id + ", nome=" + nome + ", origem=" + origem + ", destino=" + destino
                + ", distancia=" + distancia + "]";
    }

}
