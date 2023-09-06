package ronyelison.ufpb.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ronyelison.ufpb.livraria.entity.Livro;
public interface LivroRepository extends JpaRepository<Livro,Long>{
}
