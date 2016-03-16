package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TO.ClienteTO;
import dao.ConnectionFactory;
public class ClienteDAO {


	
	
	
		public void incluir(ClienteTO to) {
		String sqlInsert = "INSERT INTO cliente(id, nome, endereco, nasc, telefone) VALUES (?, ?, ?, ?, ?)";
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setInt(1, to.getId());
				stm.setString(2, to.getNome());
				stm.setString(3, to.getEndereco());
				stm.setString(4, to.getNasc());
				stm.setString(5, to.getTelefone());
				stm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		public void atualizar(ClienteTO to) {
			String sqlUpdate = "UPDATE cliente SET nome=?, fone=? WHERE id=?";
	
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getId());
				stm.setString(2, to.getNome());
				stm.setString(3, to.getEndereco());
				stm.setString(4, to.getNasc());
				stm.setString(5, to.getTelefone());
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
			String sqlSelect = "SELECT nome, fone FROM cliente WHERE cliente.id = ?";
			ClienteTO  to = new ClienteTO();
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						to.setNome(rs.getString("nome"));
					    to.setEndereco(rs.getString("Endereço"));
					    to.setNasc(rs.getString("Nascimento"));
			   		    to.setTelefone(rs.getString("Telefone"));
			   		    to.setNome(rs.getString("nome"));
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

