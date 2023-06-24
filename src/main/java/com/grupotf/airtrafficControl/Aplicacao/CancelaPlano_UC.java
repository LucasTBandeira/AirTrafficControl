package com.grupotf.airtrafficControl.Aplicacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Dominio.ServicoDePlanoDeVoo;

@Component
public class CancelaPlano_UC {
    private ServicoDePlanoDeVoo servicoDePlanoDeVoo;

    @Autowired
    public CancelaPlano_UC(ServicoDePlanoDeVoo servicoDePlanoDeVoo) {
        this.servicoDePlanoDeVoo = servicoDePlanoDeVoo;
    }

    public boolean run(Long id){
        return servicoDePlanoDeVoo.cancelaPlano(id);
    }

}
