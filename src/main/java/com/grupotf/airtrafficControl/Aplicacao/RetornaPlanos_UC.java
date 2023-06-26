package com.grupotf.airtrafficControl.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Dominio.PlanoDeVoo;
import com.grupotf.airtrafficControl.Dominio.ServicoDePlanoDeVoo;

@Component
public class RetornaPlanos_UC {
    private ServicoDePlanoDeVoo servicoDePlanoDeVoo;

    @Autowired
    public RetornaPlanos_UC(ServicoDePlanoDeVoo servicoDePlanoDeVoo) {
        this.servicoDePlanoDeVoo = servicoDePlanoDeVoo;
    }

    public List<PlanoDeVoo> run(){
        return servicoDePlanoDeVoo.all();
    }
}
