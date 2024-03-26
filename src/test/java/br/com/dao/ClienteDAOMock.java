package br.com.dao;

import br.com.domain.Cliente;

public class ClienteDAOMock implements IClienteDAO {

	@Override
	public Boolean salvar(Cliente cli) {
		return true;
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

	@Override
	public void alterar(Cliente cli) {
		// TODO Auto-generated method stub
		
	}

}
