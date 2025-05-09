package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.ComposicaoTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComposicaoTimeService {

    @Autowired
    ComposicaoTimeRepository repository;

    List<ComposicaoTime> listaPorTime(Time time){
        return repository.findAllByTime(time);
    }
}
