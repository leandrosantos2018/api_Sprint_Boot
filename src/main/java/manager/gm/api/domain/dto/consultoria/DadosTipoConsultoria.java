package manager.gm.api.domain.dto.consultoria;

import java.math.BigDecimal;

public record DadosTipoConsultoria(
        Long idTipoConsultoria,
        String nomeTipoConsultoria,
        String descricao,
        BigDecimal taxaPorHora
) {


}
