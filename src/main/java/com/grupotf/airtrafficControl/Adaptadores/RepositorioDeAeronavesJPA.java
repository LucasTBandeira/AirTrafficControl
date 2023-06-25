package com.grupotf.airtrafficControl.Adaptadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.IRepositorioDeAeronaves;

@Repository
public class RepositorioDeAeronavesJPA implements IRepositorioDeAeronaves{
    private IRepoAeronavesCRUD repoAeronaves;

    @Autowired
    public RepositorioDeAeronavesJPA(IRepoAeronavesCRUD repoAeronaves) {
        this.repoAeronaves = repoAeronaves;
    }

    @Override
    public Aeronave get(String prefixo) {
        return  repoAeronaves.findByPrefixo(prefixo);
    }
    
}
