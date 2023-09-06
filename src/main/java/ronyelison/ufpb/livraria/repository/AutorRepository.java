package ronyelison.ufpb.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ronyelison.ufpb.livraria.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
