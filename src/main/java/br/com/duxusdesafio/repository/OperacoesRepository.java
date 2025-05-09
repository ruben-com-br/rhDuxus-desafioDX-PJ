package br.com.duxusdesafio.repository;

import br.com.duxusdesafio.dto.response.IntegranteResponseDTO;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;
import java.time.LocalDate;
import java.util.List;

@Repository
public class OperacoesRepository {

    final String CT_ID = ComposicaoTime.Fields.id;
    final String CT_INTEGRANTE = ComposicaoTime.Fields.integrante;
    final String CT_TIME = ComposicaoTime.Fields.time;

    final String I_ID = Integrante.Fields.id;
    final String I_NOME = Integrante.Fields.nome;
    final String I_FRANQUIA = Integrante.Fields.franquia;
    final String I_FUNCAO = Integrante.Fields.funcao;

    final String T_DATA = Time.Fields.data;

    @PersistenceContext
    private EntityManager entityManager;

    public List<IntegranteResponseDTO> buscarIntegrantesMaisUsados(LocalDate dataInicial, LocalDate dataFinal) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<IntegranteResponseDTO> cq = cb.createQuery(IntegranteResponseDTO.class);

        Root<ComposicaoTime> root = cq.from(ComposicaoTime.class);
        Join<Object, Object> integranteJoin = root.join(CT_INTEGRANTE);
        Join<Object, Object> timeJoin = root.join(CT_TIME);

        Predicate predicate = cb.conjunction();
        predicate = cb.and(predicate, cb.greaterThanOrEqualTo(timeJoin.get(T_DATA), dataInicial));

        if (dataFinal != null) {
            predicate = cb.and(predicate, cb.lessThanOrEqualTo(timeJoin.get(T_DATA), dataFinal));
        }

        cq.select(cb.construct(
                        IntegranteResponseDTO.class,
                        integranteJoin.get(I_ID),
                        integranteJoin.get(I_FRANQUIA),
                        integranteJoin.get(I_NOME),
                        integranteJoin.get(I_FUNCAO)
                ))
                .where(predicate)
                .groupBy(integranteJoin.get(I_ID))
                .orderBy(cb.desc(cb.count(root.get(CT_ID))));

        return entityManager.createQuery(cq).getResultList();
    }
}
