package ronyelison.ufpb.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ronyelison.ufpb.livraria.entity.Livro;
import ronyelison.ufpb.livraria.service.LivroService;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }

}
