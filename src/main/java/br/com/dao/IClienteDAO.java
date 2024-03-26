package br.com.dao;

import br.com.domain.Cliente;

public interface IClienteDAO {

	void salvar(Cliente cli);
	
	Cliente buscarPorCpf(Long cpf);

	Boolean excluir(Cliente cli);

}
