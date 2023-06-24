package com.grupotf.airtrafficControl.Adaptadores;

import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.IRepositorioDeAeronaves;

public class RepositorioDeAeronavesJPA implements IRepositorioDeAeronaves{
    private IRepoAeronavesCRUD repoAeronaves;

    @Override
    public Aeronave get(String prefixo) {
        return  repoAeronaves.findByPrefixo(prefixo);
    }
    
}
