package com.grupotf.airtrafficControl.Adaptadores;

import java.util.ArrayList;
import java.util.List;

import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.AeronaveCarga;
import com.grupotf.airtrafficControl.Dominio.AeronaveParticular;
import com.grupotf.airtrafficControl.Dominio.AeronavePassageiros;
import com.grupotf.airtrafficControl.Dominio.IRepositorioDeAeronaves;

public class RepositorioDeAeronavesMem implements IRepositorioDeAeronaves{
    private List<Aeronave> aeronaves;

    public RepositorioDeAeronavesMem(){
        aeronaves = new ArrayList<Aeronave>();
        
        aeronaves.add(new AeronaveParticular(0, "PTABA", 1300, 10000, "PUC"));
        aeronaves.add(new AeronavePassageiros(1, "PPACA", 1500, 10000, "GOL", 200));
        aeronaves.add(new AeronaveCarga(2, "PUXLZ", 1700, 10000, "EVERGREEN", 30));

    }

    public Aeronave getByNome(String prefixo){
        return aeronaves.stream()
                .filter(a->a.getPrefixo().equalsIgnoreCase(prefixo))
                .findFirst()                
                .orElse(null);
    }

}
