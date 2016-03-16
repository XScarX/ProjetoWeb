package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import TO.ClienteTO;
import dao.ClienteDAO;



public class ClienteDAOTest {
	ClienteDAO dao;
	ClienteTO to;
	@Before
	public void setUp() throws Exception {
		dao = new ClienteDAO();
		to = new ClienteTO();
		to.setId(1);
		to.setNome("Rafael");
		to.setTelefone("Abc");
	    to.setNascimento("5.0");
	    to.setEndereco("Rua");
	
		
	}

	@Test
	public void testIncluir() {
		dao.incluir(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void testAtualizar() {
		to.setId(1);
		to.setNome("qweqw");
		to.setTelefone("5.00");
	    to.setNascimento("5.00");
		to.setEndereco("6.00");
		
		dao.atualizar(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void testExcluir() {
		to.setId(0);
		to.setNome(null);
		to.setTelefone(null);
	    to.setNascimento(null);
		to.setEndereco(null);
		
		dao.excluir(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void testCarregar() {
		ClienteTO cliente = new ClienteTO();
		cliente.setId(1);
		cliente.setNome("Rafael");
		cliente.setTelefone("2.22");
		cliente.setNascimento("2.44");
		cliente.setEndereco("3.55");
	
		ClienteTO novo = dao.carregar(1);
		novo.setId(1);
		assertEquals("testa inclusao", novo, cliente);
	}

}
