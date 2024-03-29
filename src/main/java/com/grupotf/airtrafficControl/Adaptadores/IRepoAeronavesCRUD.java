package com.grupotf.airtrafficControl.Adaptadores;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grupotf.airtrafficControl.Dominio.Aeronave;

public interface IRepoAeronavesCRUD extends CrudRepository<Aeronave, Long>{
    Aeronave findByPrefixo(String prefixo);
    List<Aeronave> findAll();
}
