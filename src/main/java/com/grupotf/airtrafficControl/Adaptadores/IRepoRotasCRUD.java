package com.grupotf.airtrafficControl.Adaptadores;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grupotf.airtrafficControl.Dominio.Rota;

public interface IRepoRotasCRUD extends CrudRepository<Rota, Long>{
    List<Rota> findByOrigemAndDestino(String origem, String destino);
    Rota findByNome(String nome);
    List<Rota> findAll();
}
