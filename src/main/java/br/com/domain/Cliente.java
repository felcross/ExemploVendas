package br.com.domain;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import anotacao.TipoChave;
import br.com.dao.Persistente;

@Tabela("TB_CLIENTE")
public class Cliente implements Persistente {

	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;
	@TipoChave("getCpf")
	@ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
	private String cpf;
	@ColunaTabela(dbName = "nome", setJavaName = "setNome")
	private String nome;
	
	
	public Cliente(Long id, String cpf, String nome) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
	}
	public Cliente() {
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	
	
}
