package br.com.netplus.app.services;

import br.com.netplus.app.domain.Categoria;
import br.com.netplus.app.repositories.CategoriaRepository;
import br.com.netplus.app.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: "+id+ ", tipo: "+Categoria.class.getName()));
    }

    public Categoria insert (Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

}
