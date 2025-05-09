package br.com.duxusdesafio.service;

import br.com.duxusdesafio.dto.response.IntegranteResponseDTO;
import br.com.duxusdesafio.dto.response.OpTimeDaDataResponseDTO;
import br.com.duxusdesafio.dto.response.TimeResponseDTO;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.OperacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados solicitados no desafio!
 */
@Service
public class ApiService {


    @Autowired
    TimeService timeService;

    @Autowired
    ComposicaoTimeService composicaoTimeService;

    @Autowired
    OperacoesRepository operacoesRepository;

    /**
     * Vai retornar um Time, com a composição do time daquela data
     */


//    public Time timeDaData(LocalDate data, List<Time> todosOsTimes){
//        return null;
//    }
    // Modificado método
    public OpTimeDaDataResponseDTO timeDaData(LocalDate data){

        Time time = timeService.buscarPorData(data);
        List<ComposicaoTime> composicaoTimes = composicaoTimeService.listaPorTime(time);
        List<Integrante> integrantes = composicaoTimes.stream()
                .map(ComposicaoTime::getIntegrante)
                .collect(Collectors.toList());

        TimeResponseDTO timeDTO = TimeResponseDTO.builder()
                .id(time.getId())
                .data(time.getData())
                .build();
        List<IntegranteResponseDTO> integranteDTOList = new ArrayList<>();

        for(Integrante integrante: integrantes){
           integranteDTOList.add(IntegranteResponseDTO.builder()
                   .id(integrante.getId())
                   .nome(integrante.getNome())
                   .franquia(integrante.getFranquia())
                   .funcao(integrante.getFuncao())
                   .build());
        }

        return OpTimeDaDataResponseDTO.builder()
                .time(timeDTO)
                .integrantes(integranteDTOList)
                .build();
    }

    /**
     * Vai retornar o integrante que estiver presente na maior quantidade de times
     * dentro do período
     */
    public List<IntegranteResponseDTO> integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal){
        return operacoesRepository.buscarIntegrantesMaisUsados(dataInicial,dataFinal);
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> integrantesDoTimeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }


    /**
     * Vai retornar o número (quantidade) de Franquias dentro do período
     */
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

}
