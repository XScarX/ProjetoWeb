package pro_Produto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProdutoTOTest {
	ProdutoTO to;
	@Before
	public void setUp() throws Exception {
		to = new ProdutoTO();
		to.setCodigoProduto(1);
		to.setNome("Rafael");
		to.setPreco(2.22);
		to.setPrecoDeVenda(2.44);
		to.setPrecoDeCompra(3.55);
		to.setMarca("Lg");
		to.setModelo("5444x300");
		to.setCor("Verde");
	}
	@Test
	public void testGets() {
		assertEquals("Id", to.getCodigoProduto(), 1);
		assertEquals("Nome", to.getNome(), "Rafael");
		assertEquals("Preco", to.getPreco(), 2,22);
		assertEquals("Preco de venda", to.getPrecoDeVenda(),2,44);
		assertEquals("Preco compra", to.getPrecoDeCompra(), 3,55);
		assertEquals("Marca", to.getMarca(), "Lg");
		assertEquals("Modelo", to.getModelo(), "5444x300");
		assertEquals("Cor", to.getCor(), "Verde");
	
	}
	
	
	
	

}
