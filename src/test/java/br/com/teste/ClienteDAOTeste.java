package br.com.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dao.ClienteDAO;
import br.com.dao.ClienteDAOMock;
import br.com.dao.IClienteDAO;
import br.com.domain.Cliente;
import br.com.service.ClienteService;

public class ClienteDAOTeste {

	private IClienteDAO cliDAO;
	
    private Cliente cli;
	
	public ClienteDAOTeste(){
		cliDAO = new ClienteDAOMock();
		//cliService = new ClienteService(cli);
	};
	
	@Before
	public void Init() {
		  cli = new Cliente();
		  cli.setCpf(132545055121L);
		  cli.setNome("Felipe"); 
		  cliDAO.salvar(cli);
		
		
		
	};
	
	@Test
	public void pesquisarCliente() {
		  Cliente cliConsultado = cliDAO.buscarPorCpf(cli.getCpf());
		  Assert.assertNotNull(cliConsultado);
		
	};
	
	
	@Test
	public void salvarCliente() {
		Boolean retorno = cliDAO.salvar(cli);
		Assert.assertTrue(retorno);
		 
	}
	
	@Test
	public void excluirCliente() {
		Boolean retorno = cliDAO.excluir(cli);
		Assert.assertTrue(retorno);
		 
	}
	
	@Test
	public void alterarCliente() {
	    cli.setNome("Felipe batista");
	    cliDAO.alterar(cli);
		Assert.assertEquals("Felipe batista", cli.getNome());
		 
	}
	
}
