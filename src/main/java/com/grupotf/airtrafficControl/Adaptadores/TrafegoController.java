package com.grupotf.airtrafficControl.Adaptadores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotf.airtrafficControl.Aplicacao.AltitudeSlotDTO;
import com.grupotf.airtrafficControl.Aplicacao.AprovaPlano_UC;
import com.grupotf.airtrafficControl.Aplicacao.AvaliaPlano_UC;
import com.grupotf.airtrafficControl.Aplicacao.CancelaPlano_UC;
import com.grupotf.airtrafficControl.Aplicacao.PlanoDeVooDTO;
import com.grupotf.airtrafficControl.Aplicacao.RetornaAeronaves_UC;
import com.grupotf.airtrafficControl.Aplicacao.RetornaPlanos_UC;
import com.grupotf.airtrafficControl.Aplicacao.RetornaRotas_UC;
import com.grupotf.airtrafficControl.Aplicacao.Rotas_UC;
import com.grupotf.airtrafficControl.Aplicacao.SlotsDTO;
import com.grupotf.airtrafficControl.Aplicacao.SlotsSlivres_UC;
import com.grupotf.airtrafficControl.Dominio.Aeronave;
import com.grupotf.airtrafficControl.Dominio.PlanoDeVoo;
import com.grupotf.airtrafficControl.Dominio.Rota;

@RestController
@RequestMapping("/scta")
public class TrafegoController {
    private AprovaPlano_UC aprovaPlano_UC;
    private AvaliaPlano_UC avaliaPlano_UC;
    private CancelaPlano_UC cancelaPlano_UC;
    private Rotas_UC rotas_UC;
    private SlotsSlivres_UC slotsSlivres_UC;
    private RetornaRotas_UC retornaRotas_UC;
    private RetornaAeronaves_UC retornaAeronaves_UC;
    private RetornaPlanos_UC retornaPlanos_UC;

   
    @Autowired
    public TrafegoController(AprovaPlano_UC aprovaPlano_UC, AvaliaPlano_UC avaliaPlano_UC,
            CancelaPlano_UC cancelaPlano_UC, Rotas_UC rotas_UC, SlotsSlivres_UC slotsSlivres_UC,
            RetornaRotas_UC retornaRotas_UC, RetornaAeronaves_UC retornaAeronaves_UC,
            RetornaPlanos_UC retornaPlanos_UC) {
        this.aprovaPlano_UC = aprovaPlano_UC;
        this.avaliaPlano_UC = avaliaPlano_UC;
        this.cancelaPlano_UC = cancelaPlano_UC;
        this.rotas_UC = rotas_UC;
        this.slotsSlivres_UC = slotsSlivres_UC;
        this.retornaRotas_UC = retornaRotas_UC;
        this.retornaAeronaves_UC = retornaAeronaves_UC;
        this.retornaPlanos_UC = retornaPlanos_UC;
    }

    @GetMapping("/rotas/{aeroporto_origem}/{aeroporto_destino}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Rota>> listaRota(@PathVariable("aeroporto_origem") String origem, @PathVariable("aeroporto_destino") String destino){
        List<Rota> rotas = rotas_UC.run(origem, destino);
        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(rotas);
    }
    
    @GetMapping("/cancela/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> cancelaPlano(@PathVariable("id") Long id) {
        boolean resp = cancelaPlano_UC.run(id);
        if (resp) {
            return ResponseEntity   
                    .status(HttpStatus.OK)
                    .body("Plano cancelado.");
        } else {
            return ResponseEntity   
                    .status(HttpStatus.OK)
                    .body("Plano não existente.");
        }
    }

    @PostMapping("/slotslivres")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<AltitudeSlotDTO>> slotsLivres(@RequestBody final SlotsDTO slots) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(slotsSlivres_UC.run(slots));
    }

    @PostMapping("/avaliaPlanoDeVoo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> avaliaPlano(@RequestBody final PlanoDeVooDTO plano){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(avaliaPlano_UC.run(plano));
    }


    @PostMapping("/aprovaPlanoDeVoo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> aprovaPlano(@RequestBody final PlanoDeVooDTO plano){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(aprovaPlano_UC.run(plano));
    }

    @GetMapping("/allRotas")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Rota>> retornaRotas() {
       return ResponseEntity
                .status(HttpStatus.OK)
                .body(retornaRotas_UC.run());

    }

    @GetMapping("/allPlanos")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<PlanoDeVoo>> retornaPlanos() {
       return ResponseEntity
                .status(HttpStatus.OK)
                .body(retornaPlanos_UC.run());

    }

    @GetMapping("/allAeronaves")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Aeronave>> retornaAeronaves() {
       return ResponseEntity
                .status(HttpStatus.OK)
                .body(retornaAeronaves_UC.run());

    }
}
