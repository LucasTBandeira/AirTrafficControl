package com.grupotf.airtrafficControl.Dominio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Aplicacao.AltitudeSlotDTO;
import com.grupotf.airtrafficControl.Aplicacao.PlanoDeVooDTO;
import com.grupotf.airtrafficControl.Aplicacao.SlotsDTO;

@Component
public class ServicoDePlanoDeVoo {
    private IRepositorioDeVoosCancela repositorioDeVoosCancela;
    private IRepositorioDeVoosSlots repositorioDeVoosSlots;
    private IRepositorioPlanosVoos repositorioPlanosVoos;

    private ServicoDeRotas servicoDeRotas;
    private ServicoDeAeronaves servicoDeAeronaves;

    @Autowired
    public ServicoDePlanoDeVoo(IRepositorioDeVoosCancela repositorioDeVoosCancela,
            IRepositorioDeVoosSlots repositorioDeVoosSlots, ServicoDeRotas servicoDeRotas, ServicoDeAeronaves servicoDeAeronaves, IRepositorioPlanosVoos repositorioPlanosVoos) {
        this.repositorioDeVoosCancela = repositorioDeVoosCancela;
        this.repositorioDeVoosSlots = repositorioDeVoosSlots;
        this.servicoDeRotas = servicoDeRotas;
        this.servicoDeAeronaves = servicoDeAeronaves;
        this.repositorioPlanosVoos = repositorioPlanosVoos;
    }

    public boolean cancelaPlano(Long id) {
        return repositorioDeVoosCancela.deletePlano(id);
    }

    public List<AltitudeSlotDTO> slotsLivres(SlotsDTO slots) {

        Rota rota = servicoDeRotas.get(slots.rota());
        List<PlanoDeVoo> planoDeVoos = repositorioDeVoosSlots.get(rota, slots.data());
        List<AltitudeSlotDTO> altitudeSlotDTOs = new ArrayList<>();
        int horario = Integer.parseInt(slots.horario().substring(0, slots.horario().indexOf(':')));

        if (rota == null){
            return altitudeSlotDTOs;
        }
        
        for (int i = 0; i <= 10; i++){
            for (int j = horario; j <= 23; j++){
                int altitude = 25000 + i * 1000;
                int slot = j;
                if (!verificaSlot(planoDeVoos, altitude, slot)){
                    altitudeSlotDTOs.add(new AltitudeSlotDTO(altitude, slot));
                }
            }
        }

        return altitudeSlotDTOs;

    }

    public boolean verificaSlot(List<PlanoDeVoo> planoDeVoos, int altitude, int slot) {
        for (int i = 0; i < planoDeVoos.size(); i++) {
            PlanoDeVoo plano = planoDeVoos.get(i);
            int[] slots = plano.getSlots();
            if (altitude == plano.getAltitude()){
                for (int j = 0; j < slots.length; i++){
                    if (slots[j] == slot){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String avaliaPlano(PlanoDeVooDTO planoDeVooDTO) {
       String responseVerificaAeronave = verificaAeronave(planoDeVooDTO);
       String responseVerificaRota = verificaRota(planoDeVooDTO);
       String response = responseVerificaAeronave + responseVerificaRota;
       if (response.isEmpty()){
            return "Aprovado";
       }
       return response;
    }

    public String verificaAeronave(PlanoDeVooDTO planoDeVooDTO){
        Aeronave aeronave = servicoDeAeronaves.get(planoDeVooDTO.aeronave());
        String data = planoDeVooDTO.data();
        Rota rota = servicoDeRotas.get(planoDeVooDTO.rota());
        int altitude = planoDeVooDTO.altitude();
        int[] slots = planoDeVooDTO.slots();

        String erro = "";


        if(!servicoDeAeronaves.verificaAutonomia(aeronave, rota.getDistancia())){
            erro += "Erro: combustível insuficiente.\n";
        }

        if (!servicoDeAeronaves.verificaAltitude(aeronave, altitude)){
            erro += "Erro: altitude inválida.\n";
        }

        if (!servicoDeAeronaves.verificaDisponibilidade(aeronave.getPrefixo(), data, slots)){
            erro += "Erro: avião não disponível.\n";
        }

        if (!servicoDeAeronaves.verificaHorario(aeronave, slots)){
            erro += "Erro: horário inválido.\n";
        }

        if (!servicoDeAeronaves.verificaTempo(aeronave, rota, slots)){
            erro += "Erro: tempo insuficiente.\n";
        }

        return erro;
    }

    public String verificaRota(PlanoDeVooDTO planoDeVooDTO){
        String data = planoDeVooDTO.data();
        Rota rota = servicoDeRotas.get(planoDeVooDTO.rota());
        int altitude = planoDeVooDTO.altitude();
        int[] slots = planoDeVooDTO.slots();
        List<PlanoDeVoo> planoDeVoos = repositorioPlanosVoos.get(rota, altitude, data);
        String erro = "";

        for (int i = 0; i < slots.length - 1; i++){
            if (slots[i + 1] - slots[i] != 1){
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
