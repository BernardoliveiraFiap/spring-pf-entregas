package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    EnderecoRepository repo;

    @GetMapping
    public List<Endereco> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Endereco findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }


    @GetMapping(value = "/cep/{cep}")
    public Endereco findByCep(@PathVariable String cep) {
        return repo.findByCep(cep).orElseThrow();
    }



    @GetMapping(value = "/pessoa/{id_pessoa}")
    public Class<? extends Pessoa> getPessoas(@PathVariable Long id) {
        Pessoa pessoa = repo.findById( id ).orElseThrow().getPessoa();
        return pessoa.getClass();
    }




    @Transactional
    @PostMapping
    public Endereco save(@RequestBody Endereco endereco) {
        return repo.save(endereco);
    }



}
