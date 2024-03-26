package br.com.service;

import br.com.domain.Cliente;

public interface IClienteService {

	Boolean salvar(Cliente cli);

	Cliente buscarPorCpf(Long cpf);

	Boolean excluir(Cliente cli);
	
	void alterar(Cliente cli);

    
	
}
