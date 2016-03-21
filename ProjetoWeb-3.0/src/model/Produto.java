package model;

import java.util.ArrayList;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import to.ClienteTO;
import to.ProdutoTO;

public class Produto {

	private int codigo;
	private double precoDeVenda;
	private double precoDeCompra;
	private String marca;
	private String modelo;
	private String cor;
	
	public Produto(){
		
	}
	
	public Produto(int codigo){
		setCodigo(codigo);
		
	}
	
	public Produto(int codigo, String marca, String modelo, double precoDeVenda, double precoDeCompra, String cor) {
		setCodigo(codigo);
		setMarca(marca);
		setModelo(modelo);
		setPrecoDeVenda(precoDeVenda);
		setPrecoDeCompra(precoDeCompra);
		setCor(cor);
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPrecoDeVenda(double PrecoDeVenda) {
		this.precoDeVenda = PrecoDeVenda;
	}

	public void setPrecoDeCompra(double PrecoDeCompra) {
		this.precoDeCompra = PrecoDeCompra;
	}

	public void setMarca(String Marca) {
		this.marca = Marca;
	}

	public void setModelo(String Modelo) {
		this.modelo = Modelo;
	}

	public void setCor(String Cor) {
		this.cor = Cor;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getPrecoDeVenda() {
		return precoDeVenda;
	}

	public double getPrecoDeCompra() {
		return precoDeCompra;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public void criar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setCodigo(codigo);
		to.setMarca(marca);
		to.setModelo(modelo);
		to.setPrecoDeVenda(precoDeVenda);
		to.setPrecoDeCompra(precoDeCompra);
		to.setCor(cor);
		dao.incluir(to);

	}

	public void atualizar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setCodigo(codigo);
		to.setMarca(marca);
		to.setModelo(modelo);
		to.setPrecoDeVenda(precoDeVenda);
		to.setPrecoDeCompra(precoDeCompra);
		to.setCor(cor);
		dao.atualizar(to);
	}

	public void excluir() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setCodigo(codigo);
		dao.excluir(to);
	}
	
	public ArrayList<ProdutoTO> listar() {
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<ProdutoTO> to = dao.listar();
		return to;
	}
	
	public void carregar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = dao.carregar(codigo);
		codigo = to.getCodigo();
		marca = to.getMarca();
		modelo = to.getModelo();
		precoDeVenda = to.getPrecoDeVenda();
		precoDeCompra = to.getPrecoDeCompra();
		cor = to.getCor();
	}

	public String toString() {
		return "Produto [codigo=" + codigo + ", PrecoDeVenda=" + precoDeVenda + ", PrecoDeCompra="
				+ precoDeCompra + ", Marca=" + marca + ", Modelo=" + modelo + ", Cor=" + cor + "]";
	}

}
