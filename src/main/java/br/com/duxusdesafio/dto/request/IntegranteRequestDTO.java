package br.com.duxusdesafio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteRequestDTO {
    private String franquia;
    private String nome;
    private String funcao;
}