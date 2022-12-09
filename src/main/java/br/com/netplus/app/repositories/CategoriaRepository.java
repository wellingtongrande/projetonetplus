package br.com.netplus.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.netplus.app.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
