package com.grupotf.airtrafficControl.Adaptadores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.IRepositorioDeVoosCancela;
import com.grupotf.airtrafficControl.Dominio.IRepositorioDeVoosSlots;
import com.grupotf.airtrafficControl.Dominio.IRepositorioPlanosVoos;
import com.grupotf.airtrafficControl.Dominio.PlanoDeVoo;
import com.grupotf.airtrafficControl.Dominio.Rota;

@Repository
@Primary
public class RepositorioDeVoosJPA implements IRepositorioDeVoosCancela , IRepositorioDeVoosSlots, IRepositorioPlanosVoos{
    private IRepoVoosCRUD repoVoos;

    @Autowired
    public RepositorioDeVoosJPA(IRepoVoosCRUD repoVoos) {
        this.repoVoos = repoVoos;
    }

    @Override
    public void deletePlano(Long id) {
        repoVoos.deleteById(id);
    }

    @Override
    public List<PlanoDeVoo> get(Rota rota, String data) {
        return repoVoos.findByRotaAndData(rota, data);
    }

    @Override
    public List<PlanoDeVoo> get(Rota rota, int altitude, String data) {
        return repoVoos.findByRotaAndAltitudeAndData(rota, altitude, data);
    }

    @Override
    public List<PlanoDeVoo> get(Aeronave aeronave, String data) {
        return repoVoos.findByAeronaveAndData(aeronave, data);
    }

    @Override
    public void cadastra(PlanoDeVoo voo) {
        repoVoos.save(voo);
    }

    
    
}
