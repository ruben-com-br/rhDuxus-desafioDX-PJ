package br.com.duxusdesafio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeRequestDTO {

    @NotNull
    private LocalDate data;

    @NotNull
    private List<Long> integrantesIds;

}
