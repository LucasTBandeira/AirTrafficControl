package com.grupotf.airtrafficControl.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Dominio.ServicoDePlanoDeVoo;

@Component
public class AprovaPlano_UC {
    private ServicoDePlanoDeVoo servicoDePlanoDeVoo;

    @Autowired
    public AprovaPlano_UC(ServicoDePlanoDeVoo servicoDePlanoDeVoo) {
        this.servicoDePlanoDeVoo = servicoDePlanoDeVoo;
    }

    public String run(PlanoDeVooDTO planoDeVooDTO) {
        return servicoDePlanoDeVoo.aprovaPlano(planoDeVooDTO);
    }
    
}
