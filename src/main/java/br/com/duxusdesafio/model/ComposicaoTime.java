package br.com.duxusdesafio.model;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldNameConstants
public class ComposicaoTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_time")
    private Time time;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_integrante")
    private Integrante integrante;
}
