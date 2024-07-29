package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.domain.Produto;
import br.com.jdbc.ConnectionFactory;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Integer cadastrar(Produto prod) throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		
	    try {
	    	connection = ConnectionFactory.getConnection();
	    	String sql = getSqlInsert();
	    	stm =  connection.prepareStatement(sql);
	    	adicionarParametrosInsert(stm,prod);
	    	return stm.executeUpdate();
	    }
	    catch(Exception e) {
	    	throw e;
	    } finally {
	    	//closeConnection(connection,stm,null);
	    	
	    }
	    
		
	};


	@Override
	public Integer atualizar(Produto cli) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		 try {
			 connection = ConnectionFactory.getConnection();
		    	String sql = getSqlUpdate();
		    	stm =  connection.prepareStatement(sql);
		    	adicionarParametrosUpdate(stm,cli);
		    	return stm.executeUpdate();
		    	
		    }
		    catch(Exception e) {
		    	throw e;
		    } finally {
		    	closeConnection(connection,stm,null);
		    	
		    }
			
	};

	@Override
	public Produto buscar(String code) throws Exception  {
		Connection connection = null;
		PreparedStatement stm = null;
		Produto prod = null;
		ResultSet rs = null;
		 try {
			  connection = ConnectionFactory.getConnection();
		    	String sql = getSqlSelect();
		    	stm =  connection.prepareStatement(sql);
		    	adicionarParametrosSelect(stm,code);
		    	rs = stm.executeQuery();
		    	
		    	if(rs.next()) {
		    		prod = new Produto();
		    		Long id = rs.getLong("ID");
		    		String cod= rs.getString("CODIGO");
		    		String nome = rs.getString("NOME");
		    		prod.setId(id);
		    		prod.setCodigo(cod);
		    		prod.setNome(nome);
		    	}  	
		    }
		    catch(Exception e) {
		    	throw e;
		    }finally {
		    	//closeConnection(connection,stm,rs);
		    	 }
	  return prod;	    	
	};

	
	@Override
	public Integer excluir(Produto prod) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		 try {
			 connection = ConnectionFactory.getConnection();
		    	String sql = getSqlDelete();
		    	stm =  connection.prepareStatement(sql);
		    	adicionarParametrosDelete(stm,prod);
		    	return  stm.executeUpdate();
		    	
		    }
		    catch(Exception e) {
		    	throw e;
		    } finally {
		    //	closeConnection(connection,stm,null);
		    	
		    }
		
		
	};
	
	
	@Override
	public List<Produto> buscarTodos() throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		Produto prod = null;
		ResultSet rs = null;
		List<Produto> list = new ArrayList<>();
		try {
			 connection = ConnectionFactory.getConnection();
		    	String sql = getSqlSelectAll();
		    	stm =  connection.prepareStatement(sql);
		    	rs = stm.executeQuery();
		    	
		    	while(rs.next()) {
		    		prod = new Produto();
		    		Long id = rs.getLong("ID");
		    		String nome = rs.getString("NOME");
		    		String cod = rs.getString("CODIGO");
		    		prod.setId(id);
		    		prod.setCodigo(cod);
		    		prod.setNome(nome);
		    		list.add(prod);
		    	}
		    }
		    catch(Exception e) {
		    	throw e;
		    } finally {
		    	closeConnection(connection,stm,rs);
		    	
		    }
		return list;
	};
	
	
	private String getSqlInsert() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_PRODUTO (ID,CODIGO,NOME,DESCRICAO,VALOR)");
		sb.append("VALUES (nextval('sq_produto'),?,?,?,?)");
		return sb.toString();
	};
	
	
	private String getSqlSelectAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM TB_PRODUTO");
		return sb.toString();
	};
	
	
	private void adicionarParametrosInsert(PreparedStatement stm,Produto Prod) throws SQLException {
		 stm.setString(1,Prod.getCodigo());
		 stm.setString(2,Prod.getNome());
		 stm.setString(3,Prod.getDescricao());
		 stm.setBigDecimal(4,Prod.getValor());
		};	
	
	
	
	private String getSqlSelect() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM TB_PRODUTO WHERE CODIGO = ?");
	//	sb.append(" WHERE CODIGO = ?");
		return sb.toString();
	};
	
	private void adicionarParametrosSelect(PreparedStatement stm,String codigo) throws SQLException {
	 stm.setString(1,codigo);
	};
	
	
	private String getSqlUpdate() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_PRODUTO");
		sb.append(" SET NOME = ?, CODIGO = ?");
		sb.append("WHERE ID = ?");
		return sb.toString();
	}; 
	
	private void adicionarParametrosDelete(PreparedStatement stm,Produto Prod) throws SQLException {
		 stm.setString(1,Prod.getCodigo());
		
		}
	
	 
	private String getSqlDelete() {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM TB_PRODUTO WHERE CODIGO = ?");
		//sb.append(" WHERE CODIGO = ?");
		return sb.toString();
	};
	
	private void adicionarParametrosUpdate(PreparedStatement stm,Produto Prod) throws SQLException {
		 stm.setString(1,Prod.getCodigo());
		 stm.setString(2,Prod.getNome());
		 stm.setLong(3,Prod.getId());
		}
	
	
	
	private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) throws SQLException {
		
		 try {
			 if(rs != null && !rs.isClosed()) {
				 rs.close();
			 }
			 if(stm != null && !stm.isClosed()) {
				 stm.close();
			 }
			 if(connection != null && !connection.isClosed()) {
				 connection.close();
			 }
						 
		 } 
		 catch(Exception e1) {
			 throw e1;
		 }
		
		
	}



}



