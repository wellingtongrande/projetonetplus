package br.com.netplus.app;

import br.com.netplus.app.domain.*;
import br.com.netplus.app.domain.enums.TipoCliente;
import br.com.netplus.app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "81119898154", TipoCliente.PESSOAFISICA );
        cli1.getTelefones().addAll(Arrays.asList("61987662237", "61987669988"));

        Cliente cli2 = new Cliente(null, "Wellington Gomes LTDA", "wellington@gmail.com", "99988877766", TipoCliente.PESSOAJURIDICA );
        cli2.getTelefones().addAll(Arrays.asList("61987662237", "61987669988"));

        Endereco e1 = new Endereco(null, "Quadra 21 rua 12", "200", "apt 202", "Taguatinga Norte", "72000000", cli1, c1);
        Endereco e2 = new Endereco(null, "Quadra 30 rua 1", "100", "cs 12", "Taguatinga Sul", "72000000", cli1, c2);

        Endereco e3 = new Endereco(null, "Rua 11 de cima", "999", "Loja 12", "Guara ", "72000000", cli2, c3);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        cli2.getEnderecos().addAll(Arrays.asList(e3));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));

    }
}
