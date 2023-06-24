package com.grupotf.airtrafficControl.Dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoDePlanoDeVoo {
    private IRepositorioDeVoosCancela repositorioDeVoosCancela;

    @Autowired
    public ServicoDePlanoDeVoo(IRepositorioDeVoosCancela repositorioDeVoosCancela) {
        this.repositorioDeVoosCancela = repositorioDeVoosCancela;
    }

    public boolean cancelaPlano(Long id){
        return repositorioDeVoosCancela.deletePlano(id);
    }
   
}
