package br.com.netplus.app.services;

import br.com.netplus.app.domain.Cliente;
import br.com.netplus.app.repositories.ClienteRepository;
import br.com.netplus.app.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: "+id+ ", tipo: "+Cliente.class.getName()));
    }

}
