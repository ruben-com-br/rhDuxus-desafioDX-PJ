package br.com.duxusdesafio.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IntegranteResponseDTO {
    private Long id;
    private String franquia;
    private String nome;
    private String funcao;
}
