package ronyelison.ufpb.livraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ronyelison.ufpb.livraria.entity.Livro;
import ronyelison.ufpb.livraria.repository.LivroRepository;
import ronyelison.ufpb.livraria.service.exception.EntityNotFound;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public Livro create(Livro obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Livro getId(Long id){
        Optional<Livro> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new EntityNotFound("Livro de ID: "+id+" não encontrado!");
        }
        return obj.get();
    }

    public List<Livro> getAll(){
        return repository.findAll();
    }

    public Livro update(Livro obj){
        Optional<Livro> newObj = repository.findById(obj.getId());
        if (newObj.isEmpty()){
            throw new EntityNotFound("Livro de ID: "+obj.getId()+" não encontrado!");
        }
        updateLivro(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateLivro(Optional<Livro> newObj, Livro obj) {
        newObj.get().setNome(obj.getNome());
    }
}
