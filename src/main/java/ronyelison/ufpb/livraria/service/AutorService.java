package ronyelison.ufpb.livraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ronyelison.ufpb.livraria.entity.Autor;
import ronyelison.ufpb.livraria.repository.AutorRepository;
import ronyelison.ufpb.livraria.service.exception.EntityNotFound;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    public Autor create(Autor obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Autor getId(Long id){
        Optional<Autor> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new EntityNotFound("Autor de ID: "+id+" não encontrado!");
        }
        return obj.get();
    }

    public List<Autor> getAll(){
        return repository.findAll();
    }

    public Autor update(Autor obj){
        Optional<Autor> newObj = repository.findById(obj.getId());
        if (newObj.isEmpty()){
            throw new EntityNotFound("Autor de ID: "+obj.getId()+" não encontrado!");
        }
        updateAutor(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateAutor(Optional<Autor> newObj, Autor obj) {
        newObj.get().setNome(obj.getNome());
    }
}
