package DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Builder
@Getter //Não consegue fazer a desserialização se não tiver o Getter
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {
    private Integer id;
    String tag_ativo;
    String tag_local;
    DateTime data_entrada;
    DateTime data_saida;
    Ativo ativo;
    Local local;
}
