package br.com.service;

import br.com.dao.ClienteDAO;
import br.com.dao.IClienteDAO;
import br.com.domain.Cliente;

public class ClienteService implements IClienteService {
	
	private IClienteDAO cliDao;
	
	public ClienteService(IClienteDAO cliDao) {
		 this.cliDao = cliDao;	
		
	};
	

	@Override
	public Boolean salvar(Cliente cli) {
		cliDao.salvar(cli);
       return true;
	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		// TODO Auto-generated method stub
		return cliDao.buscarPorCpf(cpf);
	}


	@Override
	public Boolean excluir(Cliente cli) {
		cliDao.excluir(cli);
		return true;
	}


	@Override
	public void alterar(Cliente cli) {
		cliDao.alterar(cli);
		
	}

}
