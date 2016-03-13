package pro_Produto;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.ConnectionFactory;

public class ProdutoDAO {

	public void incluir(ProdutoTO to) {
		String sqlInsert = "INSERT INTO produto(codigoProduto, nome, preco, precoDeVenda, precoDeCompra, Marca, Modelo, Cor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setInt(1, to.getCodigoProduto());
		stm.setString(2, to.getNome());
		stm.setDouble(3, to.getPreco());
		stm.setDouble(4, to.getPrecoDeVenda());
		stm.setDouble(5, to.getPrecoDeCompra());
		stm.setString(6, to.getMarca());
		stm.setString(7, to.getModelo());
		stm.setString(8, to.getCor());
		stm.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}

	public void atualizar(ProdutoTO to) {
		String sqlUpdate = "UPDATE produto SET nome=?, preco=?, precoDeVenda=?, precoDeCompra=?, marca=?, modelo=?, cor=? WHERE codigoProduto=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		
		stm.setInt(1, to.getCodigoProduto());
		stm.setString(2, to.getNome());
		stm.setDouble(3, to.getPreco());
		stm.setDouble(4, to.getPrecoDeVenda());
		stm.setDouble(5, to.getPrecoDeCompra());
		stm.setString(6, to.getMarca());
		stm.setString(7, to.getModelo());
		stm.setString(8, to.getCor());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}

	public void excluir(ProdutoTO to) {
		String sqlDelete = "DELETE FROM produto WHERE codigoProduto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		stm.setInt(1, to.getCodigoProduto());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	public ProdutoTO carregar(int id) {
		ProdutoTO to = new ProdutoTO();
		String sqlSelect = "SELECT nome, preco, precoDeVenda, precoDeCompra, Marca, Modelo, Cor FROM produto WHERE produto.codigoProduto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setInt(1, to.getCodigoProduto());
		try (ResultSet rs = stm.executeQuery();) {
		if (rs.next()) {
		to.setCodigoProduto(rs.getInt("codigoProduto"));
		to.setNome(rs.getString("nome"));
		to.setPreco(rs.getDouble("preco"));
		to.setPrecoDeVenda(rs.getDouble("precoDeVenda"));
		to.setPrecoDeCompra(rs.getDouble("precoDeCompra"));
		to.setMarca(rs.getString("marca"));
		to.setModelo(rs.getString("modelo"));
		to.setCor(rs.getString("cor"));
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



