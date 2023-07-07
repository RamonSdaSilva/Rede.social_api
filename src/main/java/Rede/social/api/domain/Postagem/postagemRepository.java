package Rede.social.api.domain.Postagem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postagemRepository extends JpaRepository<Postagem, Long> {
    Page<Postagem> findAllByAtivoTrue(Pageable paginacao);
}
