package br.com.duxusdesafio.service;

import br.com.duxusdesafio.dto.request.IntegranteRequestDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repository.IntegranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegranteService {

    private final IntegranteRepository repository;

    public IntegranteService(IntegranteRepository repository) {
        this.repository = repository;
    }

    public Integrante salvar(IntegranteRequestDTO dto) {
        Integrante integrante = new Integrante();
        integrante.setFranquia(dto.getFranquia());
        integrante.setNome(dto.getNome());
        integrante.setFuncao(dto.getFuncao());
        return repository.save(integrante);
    }

}
