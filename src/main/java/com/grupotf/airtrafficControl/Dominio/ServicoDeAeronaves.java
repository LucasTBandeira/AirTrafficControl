package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoDeAeronaves {
    private IRepositorioDeAeronaves repositorioDeAeronaves;
    private IRepositorioPlanosVoos repositorioPlanosVoos;

    @Autowired
    public ServicoDeAeronaves(IRepositorioDeAeronaves repositorioDeAeronaves, IRepositorioPlanosVoos repositorioPlanosVoos) {
        this.repositorioDeAeronaves = repositorioDeAeronaves;
        this.repositorioPlanosVoos = repositorioPlanosVoos;
    }

    public List<Aeronave> all(){
        return repositorioDeAeronaves.all();
    }

    public Aeronave get(String prefixo) {
        return repositorioDeAeronaves.get(prefixo);
    }

    public boolean verificaAutonomia(Aeronave aeronave, double distancia) {
        return aeronave.autonomia >= distancia;
    }

    public boolean verificaTempo(Aeronave aeronave, Rota rota, int[] slots) {
        double distancia = rota.getDistancia();
        double velocidade = aeronave.getVelocidade();
        return Math.ceil(distancia / velocidade) <= slots.length;
    }

    public boolean verificaDisponibilidade(String pre_aeronave, String data, int[] slots) {
        List<PlanoDeVoo> planoDeVoos = repositorioPlanosVoos.get(pre_aeronave, data);
        for (PlanoDeVoo plano : planoDeVoos) {
            for (int slot : slots) {
                int[] slotsPlano = plano.getSlots();
                for (int slotAux : slotsPlano) {
                    if (slot == slotAux) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean verificaAltitude(Aeronave aeronave, int altitude) {
        if (altitude < 25000 || altitude > 35000) {
            return false;
        }

        if (aeronave instanceof AeronavePassageiros) {
            return altitude > 28000;
        }

        if (aeronave instanceof AeronaveParticular) {
            return altitude >= 25000 && altitude <= 27000;
        }

        return true;
    }

    public boolean verificaHorario(Aeronave aeronave, int[] slots) {
        if (aeronave instanceof AeronaveCarga) {
            for (int slot : slots) {
                if (slot >= 6) {
                    return false;
                }
            }
        }
        return true;
    }

}
