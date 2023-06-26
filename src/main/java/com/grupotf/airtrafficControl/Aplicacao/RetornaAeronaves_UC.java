package com.grupotf.airtrafficControl.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.ServicoDeAeronaves;

@Component
public class RetornaAeronaves_UC {
    private ServicoDeAeronaves servicoDeAeronaves;

    @Autowired
    public RetornaAeronaves_UC(ServicoDeAeronaves servicoDeAeronaves) {
        this.servicoDeAeronaves = servicoDeAeronaves;
    }

    public List<Aeronave> run(){
        return servicoDeAeronaves.all();
    }
    
}
