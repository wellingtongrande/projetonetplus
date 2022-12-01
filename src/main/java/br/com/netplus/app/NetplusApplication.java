package br.com.netplus.app;

import br.com.netplus.app.domain.Categoria;
import br.com.netplus.app.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class NetplusApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NetplusApplication.class, args);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    }
}
