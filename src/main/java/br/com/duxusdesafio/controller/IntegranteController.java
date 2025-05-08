package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repository.IntegranteRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {

    private final IntegranteRepository repository;

    public IntegranteController(IntegranteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Integrante> findAll() {
        return repository.findAll();
    }
}
