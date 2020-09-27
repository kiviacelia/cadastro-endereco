package com.stoom.endereco.api;

import com.stoom.endereco.model.Endereco;
import com.stoom.endereco.service.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/endereco")
@RestController
public class EnderecoController {

    private final IEnderecoService iEnderecoService;

    @Autowired
    public EnderecoController(IEnderecoService iEnderecoService) {
        this.iEnderecoService = iEnderecoService;
    }
    @PostMapping
    public void inserirEndereco(@NonNull @RequestBody Endereco endereco){
        iEnderecoService.inserirEndereco(endereco);
    }

    @GetMapping
    public List<Endereco> buscarEnderecos(){
        return iEnderecoService.buscarEnderecos();
    }

    @GetMapping(path = "{id}")
    public Endereco buscarEnderecosID(@PathVariable("id") UUID id){
        return iEnderecoService.buscarEnderecosId(id);
    }

    @DeleteMapping(path = "{id}")
    public void deletarEndereco(@PathVariable("id") UUID id){
        iEnderecoService.deletarEndereco(id);
    }

    @PutMapping(path = "{id}")
    public void atualizarEndereco(@PathVariable("id") UUID id, @NonNull @RequestBody Endereco endereco){
        iEnderecoService.atualizarEndereco(id, endereco);
    }


}
