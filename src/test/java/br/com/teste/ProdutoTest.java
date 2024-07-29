package br.com.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.dao.ClienteDAO;
import br.com.dao.ProdutoDAO;
import br.com.domain.Cliente;
import br.com.domain.Produto;

public class ProdutoTest {
	
	private ProdutoDAO produtoDao;
	
	@Test
	public void cadastrarTest() throws Exception {
		produtoDao = new ProdutoDAO();
		Produto prod = new Produto();
		prod.setCodigo("200");
		prod.setNome("Produto teste");
		prod.setDescricao("Produto cadastrado teste");
		prod.setValor(new BigDecimal("2000"));

		Integer countCad = produtoDao.cadastrar(prod);		
		assertTrue(countCad == 1);
		Produto prod2 = new Produto();	
		prod2 = produtoDao.buscar("200");
		System.out.println(prod2.getCodigo());
		assertEquals(prod.getCodigo(),prod2.getCodigo());
		assertEquals(prod.getNome(),prod2.getNome());
		
	
		 
		
	}
	
	
	@Test
	public void excluir() throws Exception {
		produtoDao = new ProdutoDAO();
		Produto prod = new Produto();	
		prod = produtoDao.buscar("200");
		System.out.println(prod.getCodigo());
		Integer countDel = produtoDao.excluir(prod);
		assertTrue(countDel == 1);
		
		
	} 
	
	
	
	
	
	
	
	
	

}
