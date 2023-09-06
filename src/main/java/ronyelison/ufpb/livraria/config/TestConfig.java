package ronyelison.ufpb.livraria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ronyelison.ufpb.livraria.entity.Autor;
import ronyelison.ufpb.livraria.entity.Livro;
import ronyelison.ufpb.livraria.repository.AutorRepository;
import ronyelison.ufpb.livraria.repository.LivroRepository;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception {

        Autor a1 = new Autor(null, "Carlos");
        Autor a2 = new Autor(null, "Rony");

        autorRepository.saveAll(Arrays.asList(a1,a2));

        Livro l1 = new Livro(null,"Senho dos Aneis",a1);
        Livro l2 = new Livro(null,"Codigo Limpo",a2);

        livroRepository.saveAll(Arrays.asList(l1,l2));
    }
}
