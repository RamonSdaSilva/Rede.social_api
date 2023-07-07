package Rede.social.api.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuarios(
        @NotNull
        Long id,
        String nome,
        String apelido,
        String senha,
        String email,
        String telefone,
        String foto
) {
}
