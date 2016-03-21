package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.ClienteTO;

public class ClienteDAO {

	public void incluir(ClienteTO to) {
		String sqlInsert = "INSERT INTO cliente(id, nome, fone, endereco, nasc) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getId());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEndereco());
			stm.setString(5, to.getNasc());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(ClienteTO to) {
		String sqlUpdate = "UPDATE cliente SET nome=?, fone=?, endereco=?, nasc=? WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

			stm.setString(1, to.getNome());
			stm.setString(2, to.getTelefone());
			stm.setString(3, to.getEndereco());
			stm.setString(4, to.getNasc());

			stm.setInt(5, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(ClienteTO to) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public ClienteTO carregar(int id) {
		String sqlSelect = "SELECT nome, fone, endereco, nasc FROM cliente WHERE cliente.id = ?";
		ClienteTO to = new ClienteTO();
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setTelefone(rs.getString("fone"));
					to.setEndereco(rs.getString("endereco"));
					to.setNasc(rs.getString("nasc"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	public ArrayList<ClienteTO> listar() {
		ArrayList<ClienteTO> clienteTO = new ArrayList();
		String sqlSelect = "Select nome, fone, endereco, nasc, id from cliente";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try {
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					ClienteTO to = new ClienteTO();
					to.setNome(rs.getString("nome"));
					to.setTelefone(rs.getString("fone"));
					to.setEndereco(rs.getString("endereco"));
					to.setNasc(rs.getString("nasc"));
					to.setId(rs.getInt("id"));
					clienteTO.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return clienteTO;
	}
}
