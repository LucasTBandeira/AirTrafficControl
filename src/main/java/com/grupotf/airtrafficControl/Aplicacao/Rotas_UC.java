package com.grupotf.airtrafficControl.Aplicacao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Dominio.Rota;
import com.grupotf.airtrafficControl.Dominio.ServicoDeRotas;

@Component
public class Rotas_UC {
    private ServicoDeRotas servicoDeRotas;

    @Autowired
    public Rotas_UC(ServicoDeRotas servicoDeRotas) {
        this.servicoDeRotas = servicoDeRotas;
    }

    public List<Rota> run(String origem, String destino){
        return servicoDeRotas.pesquisaRota(origem, destino);
    }
    
}
