package br.com.netplus.app.services;


import br.com.netplus.app.domain.Pedido;
import br.com.netplus.app.repositories.PedidoRepository;
import br.com.netplus.app.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido bucar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: "+id+ ", tipo: "+Pedido.class.getName()));
    }
}
