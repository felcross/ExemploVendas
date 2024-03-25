package br.com.service;

import br.com.dao.ClienteDao;
import br.com.dao.IClienteDao;
import br.com.domain.Cliente;

public class ClienteService implements IClienteService {
	
	private IClienteDao cliDao;
	
	public ClienteService(IClienteDao cliDao) {
		 this.cliDao = cliDao;	
		
	};
	

	@Override
	public void salvar(Cliente cli) {
		cliDao.salvar(cli);

	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
