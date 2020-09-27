package com.stoom.endereco;

import com.stoom.endereco.model.Endereco;
import com.stoom.endereco.service.EnderecoService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
class EnderecoApplicationTests {

	@Autowired
	private EnderecoService enderecoService;

	private Endereco endereco;
	@BeforeEach
	public void setup(){
		endereco = new Endereco(UUID.fromString("f37be0d3-7849-4cb5-a55a-dccc6fff81ea"),
				"Machado de Assis",
				56,
				null,
				"Iguaçu",
				"Ipatinga",
				"Minas Gerais",
				"Brasil",
				"35162487",
				null,
				null);

	}


	@Test
	void inserirEndereco() {

		int resultado = enderecoService.inserirEndereco(endereco);
		Assert.assertEquals(1,resultado);
	}

	@Test
	void buscarEnderecos() {

		int resultado = enderecoService.inserirEndereco(endereco);
		List<Endereco> lista = enderecoService.buscarEnderecos();

		Assert.assertTrue(lista.size()>0);
	}

	@Test
	void buscarEnderecosId() {

		int resultado = enderecoService.inserirEndereco(endereco);
		List<Endereco> lista = enderecoService.buscarEnderecos();

		Endereco endereco1 = enderecoService.buscarEnderecosId(lista.get(0).getId());

		Assert.assertTrue(endereco1!=null);
		Assert.assertEquals("Machado de Assis",endereco1.getLogradouro());

	}

	@Test
	void deletarEndereco() {
		int resultado = enderecoService.inserirEndereco(endereco);
		List<Endereco> lista = enderecoService.buscarEnderecos();

		Endereco endereco1 = lista.get(0);
		enderecoService.deletarEndereco(endereco1.getId());

		List<Endereco> lista2 = enderecoService.buscarEnderecos();

		Assert.assertTrue(lista2.size()<lista.size());
	}

	@Test
	void atualizarEndereco() {

		int resultado = enderecoService.inserirEndereco(endereco);
		List<Endereco> lista = enderecoService.buscarEnderecos();

		Endereco endereco1 = lista.get(0);
		endereco1.setBairro("Centro");
		enderecoService.atualizarEndereco(endereco1.getId(),endereco1);

		Endereco endereco2 = enderecoService.buscarEnderecosId(endereco1.getId());

		Assert.assertEquals("Centro", endereco2.getBairro());
	}

@Test
	void contextLoads() {
	}

}
