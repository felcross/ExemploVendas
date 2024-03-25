package br.com.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.dao.ClienteDaoMock;
import br.com.dao.IClienteDao;
import br.com.domain.Cliente;
import br.com.service.ClienteService;
import br.com.service.IClienteService;


public class ClienteTeste {
	
	private IClienteService cliService;
	
	public ClienteTeste(){
		IClienteDao cli = new ClienteDaoMock();
		cliService = new ClienteService(cli);
		
	};

	@Test
	public void pesquisarCliente() {
		Cliente cli = new Cliente();
		  cli.setCpf(132545055121L);
		  cli.setNome("Felipe"); 
		  cliService.salvar(cli);
		  Cliente cliConsultado = cliService.buscarPorCpf(cli.getCpf());
		 Assert.assertNotNull(cliConsultado);
	}
	

	
}
