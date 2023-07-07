package Rede.social.api.domain.usuario;

public record DadosDetalhamentoUsuarios(Long id, String nome, String email, String telefone, String foto) {

    public DadosDetalhamentoUsuarios(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getFoto());
    }

}
