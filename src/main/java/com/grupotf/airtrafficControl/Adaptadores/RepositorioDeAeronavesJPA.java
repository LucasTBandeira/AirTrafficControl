package com.grupotf.airtrafficControl.Adaptadores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.IRepositorioDeAeronaves;

@Repository
@Primary
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

    @Override
    public List<Aeronave> all() {
       return repoAeronaves.findAll();
    }
    
}
