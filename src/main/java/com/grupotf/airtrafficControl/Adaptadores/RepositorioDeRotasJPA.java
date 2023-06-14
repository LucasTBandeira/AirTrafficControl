package com.grupotf.airtrafficControl.Adaptadores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.grupotf.airtrafficControl.Dominio.IRepositorioDeRotas;
import com.grupotf.airtrafficControl.Dominio.Rota;


@Repository
@Primary
public class RepositorioDeRotasJPA implements IRepositorioDeRotas{
    private IRepoRotasCRUD repoJpa;

    @Autowired
    public RepositorioDeRotasJPA(IRepoRotasCRUD repoJpa) {
        this.repoJpa = repoJpa;
    }

    public List<Rota> get(String origem, String destino){
        return repoJpa.findByOrigemAndDestino(origem, destino);
    }
    
}
