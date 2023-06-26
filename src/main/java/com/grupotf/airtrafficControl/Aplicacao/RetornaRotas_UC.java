package com.grupotf.airtrafficControl.Aplicacao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Dominio.Rota;
import com.grupotf.airtrafficControl.Dominio.ServicoDeRotas;

@Component
public class RetornaRotas_UC {
    private ServicoDeRotas servicoDeRotas;

    public RetornaRotas_UC(ServicoDeRotas servicoDeRotas) {
        this.servicoDeRotas = servicoDeRotas;
    }

    public List<Rota> run(){
        return servicoDeRotas.all();
    }
    
}
