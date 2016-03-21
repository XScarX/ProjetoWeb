package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.ClienteTO;
import to.ProdutoTO;

public class ProdutoDAO {

	public void incluir(ProdutoTO to) {
		String sqlInsert = "INSERT INTO produto(codigo, marca, modelo, precoDeVenda, precoDeCompra, cor) VALUES (?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getCodigo());
			stm.setString(2, to.getMarca());
			stm.setString(3, to.getModelo());
			stm.setDouble(4, to.getPrecoDeVenda());
			stm.setDouble(5, to.getPrecoDeCompra());
			stm.setString(6, to.getCor());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(ProdutoTO to) {
		String sqlUpdate = "UPDATE produto SET marca=?, modelo=?, precoDeVenda=?, precoDeCompra=?, cor=? WHERE codigo=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

			stm.setInt(1, to.getCodigo());
			stm.setString(2, to.getMarca());
			stm.setString(3, to.getModelo());
			stm.setDouble(4, to.getPrecoDeVenda());
			stm.setDouble(5, to.getPrecoDeCompra());
			stm.setString(6, to.getCor());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(ProdutoTO to) {
		String sqlDelete = "DELETE FROM produto WHERE codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProdutoTO carregar(int codigo) {
		ProdutoTO to = new ProdutoTO();
		String sqlSelect = "SELECT  marca, modelo, precoDeVenda, precoDeCompra, cor FROM produto WHERE produto.codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setMarca(rs.getString("marca"));
					to.setModelo(rs.getString("modelo"));
					to.setPrecoDeVenda(rs.getDouble("precoDeVenda"));
					to.setPrecoDeCompra(rs.getDouble("precoDeCompra"));
					to.setCor(rs.getString("cor"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public ArrayList<ProdutoTO> listar(){
		ArrayList<ProdutoTO> produtoTO = new ArrayList();
		String sqlSelect = "Select marca, modelo, precoDeVenda, precoDeCompra, cor, codigo from pronduto";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			try {ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					ProdutoTO to = new ProdutoTO();
					to.setMarca(rs.getString("marca"));
					to.setModelo(rs.getString("modelo"));
					to.setPrecoDeVenda(rs.getDouble("precoDeVenda"));
					to.setPrecoDeCompra(rs.getDouble("precoDeCompra"));
					to.setCor(rs.getString("cor"));
					to.setCodigo(rs.getInt("codigo"));
					produtoTO.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}	
		return produtoTO;
	}

}
