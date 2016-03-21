package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import to.EstoqueTO;


public class EstoqueDAO {
	

	public void incluir(EstoqueTO to) {
		String sqlInsert = "INSERT INTO estoque(produto, quantidade) VALUES (?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setInt(1, to.getProduto());
		stm.setInt(2, to.getQuantidade());
		stm.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}

	public void atualizar(EstoqueTO to) {
		String sqlUpdate = "UPDATE produto SET produto=?, quantiade=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		
		stm.setInt(1, to.getProduto());
		stm.setInt(2, to.getQuantidade());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}

	public void excluir(EstoqueTO to) {
		String sqlDelete = "DELETE FROM produto WHERE produto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		stm.setInt(1, to.getProduto());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	public EstoqueTO carregar(int id) {
		EstoqueTO to = new EstoqueTO();
		String sqlSelect = "SELECT produto, quantidade FROM produto WHERE produto.codigoProduto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setInt(1, to.getProduto());
		try (ResultSet rs = stm.executeQuery();) {
		if (rs.next()) {
		to.setProduto(rs.getInt("produto"));
		to.setQuantidade(rs.getInt("quantidade"));
		
		}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out .print(e1.getStackTrace());
		}
			return to;
	}



}
