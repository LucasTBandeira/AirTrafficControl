package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

public interface IRepositorioPlanosVoos {
    List<PlanoDeVoo> get(Rota rota, int altitude, String data);
    List<PlanoDeVoo> get(Aeronave aeronave, String data);
    void cadastra(PlanoDeVoo voo);
}
    

