package Rede.social.api.Controller;

import Rede.social.api.domain.Postagem.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("postagem")
public class PostagemController {

    @Autowired
    private postagemRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPostagem dados, UriComponentsBuilder uriBuilder) {
        var postagem = new Postagem(dados);
        repository.save(postagem);

        var uri = uriBuilder.path("/postagem/{id}").buildAndExpand(postagem.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosAtualizacaoPostagem(postagem));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPostagem>> listar(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPostagem::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPostagem dados) {
        var postagem = repository.getReferenceById(dados.id());
        postagem.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosAtualizacaoPostagem(postagem));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var postagem = repository.getReferenceById(id);
        postagem.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var postagem = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosAtualizacaoPostagem(postagem));
    }


}