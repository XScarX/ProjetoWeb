package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TO.ClienteTO;



public class ClienteTOTest {
	ClienteTO to;
	@Before
	public void setUp() throws Exception {
		to = new ClienteTO();
		to.setId(1);
		to.setNome("Rafael");
		to.setTelefone("telefone");	
		to.setEndereco("endereco");
		to.setNascimento("nascimento");
		to.setEndereco("endereco");
		
	}

	@Test
	public void test() {
		assertEquals("Id", to.getId(), 1);
		assertEquals("Nome", to.getNome(), "Rafael");
		assertEquals("telefone", to.getTelefone(), "telefone");
		assertEquals("Endereco", to.getEndereco(), "endereco");
		assertEquals("Nascimento", to.getNascimento(), "nascimento");

	
	}

}
