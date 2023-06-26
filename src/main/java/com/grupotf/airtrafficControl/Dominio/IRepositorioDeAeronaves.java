package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

public interface IRepositorioDeAeronaves {
    public Aeronave get(String prefixo);
    List<Aeronave> all();
}
