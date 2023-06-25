package com.grupotf.airtrafficControl.Adaptadores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.AeronaveCarga;
import com.grupotf.airtrafficControl.Dominio.AeronaveParticular;
import com.grupotf.airtrafficControl.Dominio.AeronavePassageiros;
import com.grupotf.airtrafficControl.Dominio.IRepositorioDeAeronaves;

@Repository
// @Primary
public class RepositorioDeAeronavesMem implements IRepositorioDeAeronaves{
    private List<Aeronave> aeronaves;

    public RepositorioDeAeronavesMem(){
        aeronaves = new ArrayList<Aeronave>();
        
        aeronaves.add(new AeronaveParticular(0, "PTABA", 800, 2500, "MEC1"));
        aeronaves.add(new AeronaveParticular(1, "PTACA", 800, 2500, "MEC2"));

        aeronaves.add(new AeronavePassageiros(2, "PPADA", 1200, 5000, 200,"GOL"));
        aeronaves.add(new AeronavePassageiros(3, "PPAEA", 1200, 1000, 200, "AZUL"));

        aeronaves.add(new AeronaveCarga(4, "PUXKZ", 900, 8000, 100000, "EVERGREEN"));
        aeronaves.add(new AeronaveCarga(5, "PUXLZ", 900, 8000, 100000, "EVERGREEN"));
    }

    public Aeronave get(String prefixo){
        return aeronaves.stream()
                .filter(a->a.getPrefixo().equalsIgnoreCase(prefixo))
                .findFirst()                
                .orElse(null);
    }

}