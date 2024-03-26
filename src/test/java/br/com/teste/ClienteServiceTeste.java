package br.com.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dao.ClienteDAOMock;
import br.com.dao.IClienteDAO;
import br.com.domain.Cliente;
import br.com.service.ClienteService;
import br.com.service.IClienteService;


public class ClienteServiceTeste {
	
	private IClienteService cliService;
	
	private Cliente cli;
	
	public ClienteServiceTeste(){
		IClienteDAO cli = new ClienteDAOMock();
		cliService = new ClienteService(cli);
		
	};
	
	@Before
	public void Init() {
		  cli = new Cliente();
		  cli.setCpf(132545055121L);
		  cli.setNome("Felipe"); 
		  
		
		
		
	};
	
	
	@Test
	public void pesquisarCliente() {
	
		  Cliente cliConsultado = cliService.buscarPorCpf(cli.getCpf());
		 Assert.assertNotNull(cliConsultado);
	}
	
	@Test
	public void salvarCliente() {
		Boolean retorno = cliService.salvar(cli);
		Assert.assertTrue(retorno);
		 
	}
	
	
	@Test
	public void excluirCliente() {
		Boolean retorno = cliService.excluir(cli);
		Assert.assertTrue(retorno);
		 
	}
	
	
	@Test
	public void alterarCliente() {
	    cli.setNome("Felipe batista");
		cliService.alterar(cli);
		Assert.assertEquals("Felipe batista", cli.getNome());
		 
	}
	
	

	
}
