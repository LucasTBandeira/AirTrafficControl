package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

public interface IRepositorioDeVoos {
    void deletePlano(Long id);
    List<PlanoDeVoo> get(Rota rota, String data);
    List<PlanoDeVoo> get(Rota rota, int altitude, String data);
    List<PlanoDeVoo> get(Aeronave aeronave, String data);
    void cadastra(PlanoDeVoo voo);
}
