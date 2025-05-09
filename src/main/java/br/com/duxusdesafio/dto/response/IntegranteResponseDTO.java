package br.com.duxusdesafio.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldNameConstants
public class IntegranteResponseDTO {
    private Long id;
    private String franquia;
    private String nome;
    private String funcao;
}
