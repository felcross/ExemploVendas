package br.com.service;

import br.com.domain.Cliente;

public interface IClienteService {

	void salvar(Cliente cli);

	Cliente buscarPorCpf(Long cpf);

    
	
}
