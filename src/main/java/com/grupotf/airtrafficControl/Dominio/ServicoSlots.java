package com.grupotf.airtrafficControl.Dominio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Aplicacao.AltitudeSlotDTO;
import com.grupotf.airtrafficControl.Aplicacao.SlotsDTO;

@Component
public class ServicoSlots {
    private ServicoDeRotas servicoDeRotas;
    private IRepositorioDeVoosSlots repositorioDeVoosSlots;

    @Autowired
    public ServicoSlots(ServicoDeRotas servicoDeRotas, IRepositorioDeVoosSlots repositorioDeVoosSlots) {
        this.servicoDeRotas = servicoDeRotas;
        this.repositorioDeVoosSlots = repositorioDeVoosSlots;
    }

    public List<AltitudeSlotDTO> slotsLivres(SlotsDTO slots) {

        Rota rota = servicoDeRotas.get(slots.rota());
        List<PlanoDeVoo> planoDeVoos = repositorioDeVoosSlots.get(rota, slots.data());
        List<AltitudeSlotDTO> altitudeSlotDTOs = new ArrayList<>();
        int horario = Integer.parseInt(slots.horario().substring(0, slots.horario().indexOf(':')));

        if (rota == null) {
            return altitudeSlotDTOs;
        }

        for (int i = 0; i <= 10; i++) {
            for (int j = horario; j <= 23; j++) {
                int altitude = 25000 + i * 1000;
                int slot = j;
                if (!verificaSlot(planoDeVoos, altitude, slot)) {
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
            if (altitude == plano.getAltitude()) {
                for (int j = 0; j < slots.length; i++) {
                    if (slots[j] == slot) {
                        return true;
                    }
                }
            }
        }
        return false;
    } 
}
