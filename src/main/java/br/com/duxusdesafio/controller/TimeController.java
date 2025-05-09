package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.dto.request.TimeRequestDTO;
import br.com.duxusdesafio.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping
    public ResponseEntity<String> cadastrarTime(@RequestBody @Valid TimeRequestDTO request) {
        timeService.cadastrarTime(request);
        return ResponseEntity.ok("Time cadastrado com sucesso.");
    }
}
