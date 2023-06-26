package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Aplicacao.PlanoDeVooDTO;

@Component
public class ServicoVerificacaoPlano {
    private ServicoDeAeronaves servicoDeAeronaves;
    private ServicoDeRotas servicoDeRotas;
    private IRepositorioPlanosVoos repositorioPlanosVoos;
    
    @Autowired
    public ServicoVerificacaoPlano(ServicoDeAeronaves servicoDeAeronaves, ServicoDeRotas servicoDeRotas,
            IRepositorioPlanosVoos repositorioPlanosVoos) {
        this.servicoDeAeronaves = servicoDeAeronaves;
        this.servicoDeRotas = servicoDeRotas;
        this.repositorioPlanosVoos = repositorioPlanosVoos;
    }

    public String verificaAeronave(PlanoDeVooDTO planoDeVooDTO) {
        Aeronave aeronave = servicoDeAeronaves.get(planoDeVooDTO.aeronave());
        String data = planoDeVooDTO.data();
        Rota rota = servicoDeRotas.get(planoDeVooDTO.rota());
        int altitude = planoDeVooDTO.altitude();
        int[] slots = planoDeVooDTO.slots();

        String erro = "";

        if (!servicoDeAeronaves.verificaAutonomia(aeronave, rota.getDistancia())) {
            erro += "Erro: combustível insuficiente.\n";
        }

        if (!servicoDeAeronaves.verificaAltitude(aeronave, altitude)) {
            erro += "Erro: altitude inválida.\n";
        }

        if (!servicoDeAeronaves.verificaDisponibilidade(aeronave.getPrefixo(), data, slots)) {
            erro += "Erro: avião não disponível.\n";
        }

        if (!servicoDeAeronaves.verificaHorario(aeronave, slots)) {
            erro += "Erro: horário inválido.\n";
        }

        if (!servicoDeAeronaves.verificaTempo(aeronave, rota, slots)) {
            erro += "Erro: tempo insuficiente.\n";
        }

        return erro;
    }

    public String verificaRota(PlanoDeVooDTO planoDeVooDTO) {
        String data = planoDeVooDTO.data();
        Rota rota = servicoDeRotas.get(planoDeVooDTO.rota());
        int altitude = planoDeVooDTO.altitude();
        int[] slots = planoDeVooDTO.slots();
        List<PlanoDeVoo> planoDeVoos = repositorioPlanosVoos.get(rota, altitude, data);
        String erro = "";

        for (int i = 0; i < slots.length - 1; i++) {
            if (slots[i + 1] - slots[i] != 1) {
                erro += "Erro: alocação inválida dos slots.\n";
                break;
            }
        }

        for (PlanoDeVoo plano : planoDeVoos) {
            for (int slot : slots) {
                int[] slotsPlano = plano.getSlots();
                for (int slotAux : slotsPlano) {
                    if (slot == slotAux) {
                        return erro += "Erro: slot ocupado.\n";
                    }
                }
            }
        }

        return erro;
    }
}
