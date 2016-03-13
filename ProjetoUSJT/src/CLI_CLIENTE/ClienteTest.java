package CLI_CLIENTE;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente cliente, copia;
	
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente(1, "Rafael","12301312", "Rua kasda", "01/01/01");

		copia = new Cliente(1, "Rafael","12301312", "Rua kasda", "01/01/01");
	}

	@Test
	public void test() {
		assertEquals("ID" , cliente.getId() , 1);
		assertEquals("Nome", cliente.getNome(), "Rafael");
		assertEquals("Tefone", cliente.getTelefone(), "12301312" );
		assertEquals("Endereco", cliente.getEndereco(), "Rua kasda");
		assertEquals("Data", cliente.getEndereco(), "01/01/01");

	}

	public void test00Carregar() {
		
		Cliente novo = new Cliente(1, null, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, cliente);
	}

	@Test
	public void test01Criar() {
		cliente.criar();
		cliente.carregar();
		assertEquals("testa criacao", cliente, copia);
	}

	public void test03Excluir() {
		cliente.setId(0);
		copia.setId(0);
		cliente.setNome(null);
		copia.setNome(null);
		cliente.setTelefone(null);
		copia.setTelefone(null);
		cliente.setNascimento(null);
		copia.setNascimento(null);
		cliente.setEndereco(null);
		copia.setEndereco(null);
		cliente.excluir();
		assertEquals("testa inclusao", cliente, copia);
	}

	@Test
	public void test02Atualizar() {
		cliente.setId(5);
		cliente.setNome("Manca");
		cliente.setTelefone("Abc");
	    cliente.setNascimento("5.0");
	    cliente.setEndereco("Rua");
	
		
		copia.setId(6);
		copia.setNome("Manca");
		copia.setTelefone("3.0");
		copia.setNascimento("5.0");
		copia.setEndereco("6.0");
	
		assertEquals("testa inclusao", cliente, copia);
	}
}
