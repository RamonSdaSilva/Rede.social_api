package Rede.social.api.domain.Postagem;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "postagem")
@Entity(name = "Postagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Postagem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String post;
    private String video;
    private Boolean ativo;
    public Postagem(@Valid DadosCadastroPostagem dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.post = dados.post();
        this.video = dados.video();
    }

    public void atualizarInformacoes(DadosAtualizacaoPostagem dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.post() != null){
            this.post = dados.post();
        }
        if (dados.video() != null){
            this.video = dados.video();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
