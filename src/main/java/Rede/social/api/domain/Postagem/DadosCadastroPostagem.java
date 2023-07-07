package Rede.social.api.domain.Postagem;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record DadosCadastroPostagem(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        @URL
        String post,
        String video
) {

}
