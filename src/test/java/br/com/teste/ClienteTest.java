package br.com.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.dao.ClienteDAO;
import br.com.domain.Cliente;

public class ClienteTest {
	
	private ClienteDAO clienteDao;
	
	@Test
	public void cadastrarTest() throws Exception {
		clienteDao = new ClienteDAO();
		
		Cliente cli = new Cliente();
		cli.setCpf("20");
		cli.setNome("clienteTeste");
		System.out.println(cli.getCpf()+"primeiro teste");
		Integer countCad = clienteDao.cadastrar(cli);		
		assertTrue(countCad == 1);
		Cliente cli2 = new Cliente();	
		 cli2 = clienteDao.buscar("20");
		System.out.println(cli2.getCpf());
		assertEquals(cli.getCpf(),cli2.getCpf());
		assertEquals(cli.getNome(),cli2.getNome());
		
	
		
		
	}
	
	
	@Test
	public void excluir() throws Exception {
		clienteDao = new ClienteDAO();
		Cliente cli = new Cliente();	
		cli = clienteDao.buscar("20");
		System.out.println(cli.getCpf());
		Integer countDel = clienteDao.excluir(cli);
		assertTrue(countDel == 1);
		System.out.println(); 
		
		
	} 
	
	
	
	
	
	
	
	
	

}
