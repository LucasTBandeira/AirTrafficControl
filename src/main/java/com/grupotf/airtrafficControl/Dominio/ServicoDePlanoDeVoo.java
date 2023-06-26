package com.grupotf.airtrafficControl.Dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupotf.airtrafficControl.Aplicacao.PlanoDeVooDTO;

@Component
public class ServicoDePlanoDeVoo {
    private IRepositorioDeVoosCancela repositorioDeVoosCancela;
    private IRepositorioPlanosVoos repositorioPlanosVoos;

    private ServicoDeRotas servicoDeRotas;
    private ServicoDeAeronaves servicoDeAeronaves;
    private ServicoVerificacaoPlano servicoVerificacaoPlano;

    @Autowired
    public ServicoDePlanoDeVoo(IRepositorioDeVoosCancela repositorioDeVoosCancela, ServicoDeRotas servicoDeRotas,
            ServicoDeAeronaves servicoDeAeronaves, IRepositorioPlanosVoos repositorioPlanosVoos, ServicoVerificacaoPlano servicoVerificacaoPlano) {
        this.repositorioDeVoosCancela = repositorioDeVoosCancela;
        this.servicoDeRotas = servicoDeRotas;
        this.servicoDeAeronaves = servicoDeAeronaves;
        this.repositorioPlanosVoos = repositorioPlanosVoos;
        this.servicoVerificacaoPlano = servicoVerificacaoPlano;
    }

       public List<PlanoDeVoo> all(){
        return repositorioPlanosVoos.all();
    }

    public boolean cancelaPlano(Long id) {
        return repositorioDeVoosCancela.deletePlano(id);
    }

    public String avaliaPlano(PlanoDeVooDTO planoDeVooDTO) {
        Aeronave aeronave = servicoDeAeronaves.get(planoDeVooDTO.aeronave());
        Rota rota = servicoDeRotas.get(planoDeVooDTO.rota());

        if (rota == null) {
            return "Erro: rota não existe";
        }

        if (aeronave == null) {
            return "Erro: aeronave não existe";
        }

        String responseVerificaAeronave = servicoVerificacaoPlano.verificaAeronave(planoDeVooDTO);
        String responseVerificaRota = servicoVerificacaoPlano.verificaRota(planoDeVooDTO);
        String response = responseVerificaAeronave + responseVerificaRota;

        if (response.isEmpty()) {
            return "Aprovado";
        }
        return response;
    }

    public String aprovaPlano(PlanoDeVooDTO planoDeVooDTO) {
        String response = avaliaPlano(planoDeVooDTO);
        if (response.equals("Aprovado")) {
            PlanoDeVoo plano = new PlanoDeVoo(planoDeVooDTO.aeronave(), servicoDeRotas.get(planoDeVooDTO.rota()),
                    planoDeVooDTO.altitude(), planoDeVooDTO.data(), planoDeVooDTO.slots());
            repositorioPlanosVoos.cadastra(plano);
            return "Liberado: id " + repositorioPlanosVoos.count().toString();
        }
        return response;
    }

}
