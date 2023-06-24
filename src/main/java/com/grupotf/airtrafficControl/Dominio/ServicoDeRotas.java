package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoDeRotas {
    private IRepositorioDeRotas repositorioDeRotas;
    
    
    @Autowired
    public ServicoDeRotas(IRepositorioDeRotas repositorioDeRotas) {
        this.repositorioDeRotas = repositorioDeRotas;
    }

    
    public List<Rota> pesquisaRota(String origem, String destino){
        return repositorioDeRotas.get(origem.toLowerCase(), destino.toLowerCase());
    }

    public Rota get(String nome){
        return repositorioDeRotas.get(nome);
    }
}
