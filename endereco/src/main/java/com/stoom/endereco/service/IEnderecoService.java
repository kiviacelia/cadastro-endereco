package com.stoom.endereco.service;

import com.stoom.endereco.model.Endereco;

import java.util.List;
import java.util.UUID;

public interface IEnderecoService {

    int inserirEndereco(Endereco endereco);

    List<Endereco> buscarEnderecos();

    Endereco buscarEnderecosId(UUID id);

    int deletarEndereco(UUID id);

    int atualizarEndereco(UUID id, Endereco newEndereco);


}
