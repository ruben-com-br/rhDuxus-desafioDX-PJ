package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.dto.request.IntegranteRequestDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repository.IntegranteRepository;
import br.com.duxusdesafio.service.IntegranteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {

    private final IntegranteRepository repository;
    private final IntegranteService service;

    public IntegranteController(IntegranteRepository repository,
                                IntegranteService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Integrante> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Integrante> create(@RequestBody IntegranteRequestDTO dto) {
        Integrante saved = service.salvar(dto);
        return ResponseEntity.created(URI.create("/integrantes/" + saved.getId())).body(saved);
    }
}
