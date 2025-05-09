package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.dto.response.IntegranteResponseDTO;
import br.com.duxusdesafio.dto.response.OpTimeDaDataResponseDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/operacoes")
public class OperacoesController {

    @Autowired
    ApiService apiService;

    // Nome do Rest fora do padrao, par ser igual
    @GetMapping("/time-da-data/{data}")
    public ResponseEntity<OpTimeDaDataResponseDTO> obterTimePorData(
            @PathVariable("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        OpTimeDaDataResponseDTO timeComParticipantes = apiService.timeDaData(data);

        return ResponseEntity.ok().body(timeComParticipantes);
    }

    @GetMapping(value = "/integrante-mais-usado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<IntegranteResponseDTO>> obterIntegranteMaisUsado(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {

        List<IntegranteResponseDTO> integrantesDTO = apiService.integranteMaisUsado(dataInicial, dataFinal);

        if (integrantesDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(integrantesDTO);
    }
}

