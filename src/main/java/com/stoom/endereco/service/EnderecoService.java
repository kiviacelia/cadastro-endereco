package com.stoom.endereco.service;

import com.stoom.endereco.dao.IEnderecoDAO;
import com.stoom.endereco.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService implements IEnderecoService{

    private final IEnderecoDAO iEnderecoDAO;

    @Autowired
    public EnderecoService(@Qualifier("enderecoDAO") IEnderecoDAO iEnderecoDAO){
        this.iEnderecoDAO = iEnderecoDAO;
    }

    @Override
    public int inserirEndereco(Endereco endereco) {
       UUID id = UUID.randomUUID();
       endereco.setId(id);
       int result = iEnderecoDAO.inserirEndereco(endereco);

       return result;
    }

    @Override
    public List<Endereco> buscarEnderecos() {
        return iEnderecoDAO.buscarEnderecos();
    }

    @Override
    public Endereco buscarEnderecosId(UUID id) {
        return iEnderecoDAO.buscarEnderecosId(id);
    }

    @Override
    public int deletarEndereco(UUID id) {
        return iEnderecoDAO.deletarEndereco(id);
    }

    @Override
    public int atualizarEndereco(UUID id, Endereco newEndereco) {
        return iEnderecoDAO.atualizarEndereco(id, newEndereco);
    }
}
