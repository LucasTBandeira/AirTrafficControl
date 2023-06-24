package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

public interface IRepositorioDeVoosSlots {
    List<PlanoDeVoo> get(Rota rota, String data);
}
