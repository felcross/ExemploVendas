package br.com.dao;

import br.com.domain.Cliente;

public interface IClienteDAO {

	Boolean salvar(Cliente cli);
	
	Cliente buscarPorCpf(Long cpf);

	Boolean excluir(Cliente cli);
	
	void alterar(Cliente cli);

}
