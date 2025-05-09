package br.com.duxusdesafio.repository;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ComposicaoTimeRepository extends JpaRepository<ComposicaoTime, Long> {
    List<ComposicaoTime> findAllByTime(Time time);
}