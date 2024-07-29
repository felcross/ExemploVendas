package br.com.dao;

import java.util.List;

import br.com.domain.Produto;

public interface IProdutoDAO {

	public Integer cadastrar(Produto cli) throws Exception;
	public Integer atualizar(Produto cli) throws Exception;
	public Produto buscar(String code) throws Exception;
	public List<Produto> buscarTodos() throws Exception;
	public Integer excluir(Produto cli) throws Exception;
	

}
