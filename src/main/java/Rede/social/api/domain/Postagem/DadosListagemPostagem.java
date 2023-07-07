package Rede.social.api.domain.Postagem;

public record DadosListagemPostagem(Long id, String titulo, String descricao, String post, String video) {

    public DadosListagemPostagem(Postagem postagem) {
        this(postagem.getId(), postagem.getTitulo(), postagem.getDescricao(), postagem.getPost(), postagem.getVideo());
    }

}
