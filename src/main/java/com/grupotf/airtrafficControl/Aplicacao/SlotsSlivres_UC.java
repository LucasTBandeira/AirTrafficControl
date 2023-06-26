package com.grupotf.airtrafficControl.Aplicacao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Dominio.ServicoSlots;

@Component
public class SlotsSlivres_UC {
    private ServicoSlots servicoSlots;

    @Autowired
    public SlotsSlivres_UC(ServicoSlots servicoSlots) {
        this.servicoSlots = servicoSlots;
    }

    public List<AltitudeSlotDTO> run(SlotsDTO slots) {
        return servicoSlots.slotsLivres(slots);
    }
    
}
