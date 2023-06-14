package com.grupotf.airtrafficControl.Adaptadores;

import org.springframework.data.repository.CrudRepository;

import com.grupotf.airtrafficControl.Dominio.PlanoDeVoo;

public interface IRepoVoosCRUD extends CrudRepository<PlanoDeVoo, Long> {
    
}
