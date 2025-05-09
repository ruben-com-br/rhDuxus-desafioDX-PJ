package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.dto.response.OpTimeDaDataResponseDTO;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

}
