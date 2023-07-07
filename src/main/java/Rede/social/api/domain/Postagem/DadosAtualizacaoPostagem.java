package Rede.social.api.domain.Postagem;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPostagem(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        String post,
        String video
        ) {

        public DadosAtualizacaoPostagem(Postagem postagem){
                this(postagem.getId(), postagem.getTitulo(), postagem.getDescricao(), postagem.getPost(), postagem.getVideo());
        }
}
