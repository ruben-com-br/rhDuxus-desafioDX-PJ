package br.com.duxusdesafio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpTimeDaDataResponseDTO {
    TimeResponseDTO time;
    List<IntegranteResponseDTO> integrantes;
}
