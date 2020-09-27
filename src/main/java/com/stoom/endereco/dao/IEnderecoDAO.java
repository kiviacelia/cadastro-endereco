package com.stoom.endereco.dao;

import com.stoom.endereco.model.Endereco;

import java.util.List;
import java.util.UUID;

public interface IEnderecoDAO {

    int inserirEndereco(Endereco endereco);

    List<Endereco> buscarEnderecos();

    Endereco buscarEnderecosId(UUID id);

    int deletarEndereco(UUID id);

    int atualizarEndereco(UUID id, Endereco endereco);

}
