package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MercadoriaDAO {

	public void incluir(MercadoriaTO to) {
		String sqlInsert = "INSERT INTO mercadoria(codigo, tipoMerc, nome, quantidade, preco, tipoNegocio) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getCodigo());
			stm.setString(2, to.getTipoMerc());
			stm.setString(3, to.getNome());
			stm.setInt(4, to.getQuantidade());
			stm.setDouble(5, to.getPreco());
			stm.setString(6, to.getTipoNegocio());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(MercadoriaTO to) {
		String sqlUpdate = "UPDATE mercadoria SET tipoMerc=?, nome=?, quantidade=?, preco=?, tipoNegocio WHERE codigo=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

			stm.setString(1, to.getTipoMerc());
			stm.setString(2, to.getNome());
			stm.setInt(3, to.getQuantidade());
			stm.setDouble(4, to.getPreco());
			stm.setString(5, to.getTipoNegocio());

			stm.setInt(6, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(MercadoriaTO to) {
		String sqlDelete = "DELETE FROM mercadoria WHERE codigo = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public MercadoriaTO carregar(int id) {
		String sqlSelect = "SELECT tipoMerc, nome, quantidade, preco, tipoNegocio FROM meterial WHERE mercadoria.codigo = ?";
		MercadoriaTO to = new MercadoriaTO();
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setTipoMerc(rs.getString("tipoMerc"));
					to.setNome(rs.getString("nome"));
					to.setQuantidade(rs.getInt("quantidade"));
					to.setPreco(rs.getDouble("preco"));
					to.setTipoNegocio(rs.getString("tipoNegocio"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

}
