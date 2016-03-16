package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import TO.ProdutoTO;
import dao.ProdutoDAO;

public class ProdutoDAOTest {
	ProdutoDAO dao;
	ProdutoTO to;
	@Before
	public void setUp() throws Exception {
		dao = new ProdutoDAO();
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
	public void testIncluir() {
		dao.incluir(to);
		ProdutoTO novo = dao.carregar(to.getCodigoProduto());
		novo.setCodigoProduto(to.getCodigoProduto());
		assertEquals("testa inclusao", novo, to);

	}

	@Test
	public void testAtualizar() {
		to.setCodigoProduto(1);
		to.setNome("qweqw");
		to.setPreco(5.00);
	    to.setPrecoDeVenda(5.00);
		to.setPrecoDeCompra(6.00);
		to.setMarca("asf");
		to.setModelo("wqr");
		to.setCor("adsd");
		dao.atualizar(to);
		ProdutoTO novo = dao.carregar(to.getCodigoProduto());
		novo.setCodigoProduto(to.getCodigoProduto());
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void testExcluir() {
		to.setCodigoProduto(0);
		to.setNome(null);
		to.setPreco(0.0);
	    to.setPrecoDeVenda(0.0);
		to.setPrecoDeCompra(0.0);
		to.setMarca(null);
		to.setModelo(null);
		to.setCor(null);
		dao.excluir(to);
		ProdutoTO novo = dao.carregar(to.getCodigoProduto());
		novo.setCodigoProduto(to.getCodigoProduto());
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void test00Carregar() {
		
		ProdutoTO produto = new ProdutoTO();
		 produto.setCodigoProduto(1);
		 produto.setNome("Rafael");
		 produto.setPreco(2.22);
		 produto.setPrecoDeVenda(2.44);
		 produto.setPrecoDeCompra(3.55);
		 produto.setMarca("Lg");
		 produto.setModelo("5444x300");
		 produto.setCor("Verde");
		ProdutoTO novo = dao.carregar(1);
		novo.setCodigoProduto(1);
		assertEquals("testa inclusao", novo, produto);
	}

}
