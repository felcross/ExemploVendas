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
		cli.setCodigo("10");
		cli.setNome("clienteTeste");
		System.out.println(cli.getCodigo()+"primeiro teste");
		Integer countCad = clienteDao.cadastrar(cli);		
		assertTrue(countCad == 1);
		Cliente cli2 = new Cliente();	
		 cli2 = clienteDao.buscar("10");
		System.out.println(cli2.getCodigo());
	 	assertNull(cli2);
		assertEquals(cli.getCodigo(),cli2.getCodigo());
		assertEquals(cli.getNome(),cli2.getNome());
		
		Integer countDel = clienteDao.excluir(cli);
		assertTrue(countDel == 1);
		System.out.println(); 
		
		
	}
	
	
	
	
	
	
	
	
	

}
