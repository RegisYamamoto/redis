package com.regis.redis.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@GetMapping(value = "/{id}")
	@Cacheable("cliente")
	public String buscaClientePorId(Integer id) {
		System.out.println("Entrou no método buscaClientePorId(), sem usar o cache");
		String cliente = "Maurício";
		return cliente;
	}
	
	@GetMapping(value = "")
	@Cacheable("clientes")
	public List<String> buscaClientes() {
		System.out.println("Entrou no método buscaClientes(), sem usar o cache");
		List<String> clientes = Arrays.asList("Ana", "Maria", "Vilmar");
		return clientes;
	}
	
	// Limpar o cache manualmente
//	@DeleteMapping(value = "/cache")
//	@CacheEvict("clientes")
//	public String limparCache() {
//		System.out.println("Limpando o cache");
//		return "Cache foi limpo com sucesso";
//	}
	
}
