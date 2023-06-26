package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

public interface IRepositorioDeRotas {
    List<Rota> get(String origem, String destino);
    Rota get(String nome);
    List<Rota> all();
}
