package br.com.dao;

import br.com.domain.Cliente;

public interface IClienteDao {

	void salvar(Cliente cli);
	
	Cliente buscarPorCpf(Long cpf);

}
