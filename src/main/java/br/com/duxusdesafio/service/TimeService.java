package br.com.duxusdesafio.service;

import br.com.duxusdesafio.dto.request.TimeRequestDTO;
import br.com.duxusdesafio.exception.NotDataFoundException;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.ComposicaoTimeRepository;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.repository.IntegranteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;

    @Autowired
    private ApiService apiService;

    public void cadastrarTime(TimeRequestDTO request) {
        Time time = Time.builder().data(request.getData()).build();
        timeRepository.save(time);

        List<Integrante> integrantes = integranteRepository.findAllById(request.getIntegrantesIds());
        for (Integrante integrante : integrantes) {
            ComposicaoTime composicao = ComposicaoTime.builder()
                    .time(time)
                    .integrante(integrante)
                    .build();
            composicaoTimeRepository.save(composicao);
        }
    }

    public List<Time> buscarTodosOsTimes(){
        return timeRepository.findAll();
    }

    public Time buscarPorData(LocalDate data) {
        return timeRepository
                .findByData(data)
                .orElseThrow(() -> new NotDataFoundException("Nenhum time encontrado para a data: " + data));
    }
}
