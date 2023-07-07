package Rede.social.api.domain.usuario;

public record DadosListagemUsuario(Long id, String nome, String email, String telefone) {

    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }

}
