package com.grupotf.airtrafficControl.Aplicacao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Dominio.ServicoDePlanoDeVoo;

@Component
public class SlotsSlivres_UC {
    private ServicoDePlanoDeVoo servicoDePlanoDeVoo;

    @Autowired
    public SlotsSlivres_UC(ServicoDePlanoDeVoo servicoDePlanoDeVoo) {
        this.servicoDePlanoDeVoo = servicoDePlanoDeVoo;
    }

    public List<AltitudeSlotDTO> run(SlotsDTO slots) {
        return servicoDePlanoDeVoo.slotsLivres(slots);
    }
    
}
