package pro_Produto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {
	
	Produto produto;
	Produto copia;
	@Before
	
	public void setUp() throws Exception {
		produto = new Produto(1, "Rafael", 2.22, 2.44, 3.55, "Lg", "5444x300", "Verde");

	copia = new Produto(1, "Rafael", 2.22, 2.44, 3.55, "Lg", "5444x300", "Verde");
	}
	
	@Test
	public void testSet() {
		assertEquals("ID" , produto.getCodigoProduto() , 1);
		assertEquals("Nome", produto.getNome(), "Rafael");
		assertEquals("Preco", produto.getPreco(), 2,22);
		assertEquals("Preco de Venda", produto.getPrecoDeVenda(), 2,44);
		assertEquals("Preco De Compra", produto.getPrecoDeCompra(), 3,55);
		assertEquals("Marca", produto.getMarca(), "Lg");
		assertEquals("Modelo", produto.getModelo(), "5444x300");
		assertEquals("cor", produto.getCor(), "Verde");
	}
	
	@Test
	public void test00Carregar() {
		
		Produto novo = new Produto(1, null, 0.0, 0.0, 0.0, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, produto);
	}
	
	
@Test
	public void test01Criar() {
		produto.criar();
		produto.carregar();
		assertEquals("testa criacao", produto, copia);
	}
	
	@Test
	
	public void test03Excluir() {
		produto.setCodigoProduto(0);
		copia.setCodigoProduto(0);
		produto.setNome(null);
		copia.setNome(null);
		produto.setPreco(0.0);
		copia.setPreco(0.0);
		produto.setPrecoDeVenda(0.0);
		copia.setPrecoDeVenda(0.0);
		produto.setPrecoDeCompra(0.0);
		copia.setPrecoDeCompra(0.0);
		copia.setMarca(null);
		produto.setMarca(null);
		copia.setModelo(null);
		produto.setModelo(null);
		copia.setCor(null);
		copia.setCor(null);

		produto.excluir();
		assertEquals("testa inclusao", produto, copia);
	}
	
	
	@Test
	public void test02Atualizar() {
		produto.setCodigoProduto(5);
		produto.setNome("Manca");
		produto.setPreco(3.0);
	    produto.setPrecoDeVenda(5.0);
		produto.setPrecoDeCompra(6.0);
		produto.setMarca("Apple");
		produto.setModelo("ZZMC");
		produto.setCor("Amarelo");
		produto.setCodigoProduto(5);
		
		
		copia.setNome("Manca");
		copia.setPreco(3.0);
		copia.setPrecoDeVenda(5.0);
		copia.setPrecoDeCompra(6.0);
		copia.setMarca("Apple");
		copia.setModelo("ZZMC");
		copia.setCor("Amarelo");
		assertEquals("testa inclusao", produto, copia);
	}

}

