package com.grupotf.airtrafficControl.Adaptadores;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.PlanoDeVoo;
import com.grupotf.airtrafficControl.Dominio.Rota;

public interface IRepoVoosCRUD extends CrudRepository<PlanoDeVoo, Long> {
    void deleteById(Long id);
    List<PlanoDeVoo> findByRotaAndData(Rota rota, String data);
    List<PlanoDeVoo> findByRotaAndAltitudeAndData(Rota rota, int altitude, String data);
    List<PlanoDeVoo> findByAeronaAndData(Aeronave aeronave, String data);
}
