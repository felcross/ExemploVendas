package br.com.dao;

import br.com.domain.Cliente;

public class ClienteDAOMock implements IClienteDAO {

	@Override
	public void salvar(Cliente cli) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		Cliente cli = new Cliente();
		cli.setCpf(cpf);
		return cli;
	}

	@Override
	public Boolean excluir(Cliente cli) {
		return true;
		// TODO Auto-generated method stub
		
	}

}
