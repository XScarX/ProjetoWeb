package model;

import TO.ProdutoTO;
import dao.ProdutoDAO;


public class Produto {

		private int codigoProduto;
		private String nome;
		private double preco;
		private double precoDeVenda;
		private double precoDeCompra;
		private String marca;
		private String modelo;
		private String cor;
		
		public Produto(int CodigoProduto, String Nome, double Preco, double PrecoDeVenda, double PrecoDeCompra, String Marca, String Modelo, String Cor){
			setCodigoProduto(CodigoProduto);
			setNome(Nome);
			setPreco(Preco);
			setPrecoDeVenda(PrecoDeVenda);
			setPrecoDeCompra(PrecoDeCompra);
			setMarca(Marca);
			setModelo(Modelo);
			setCor(Cor);
		}
		
		public void setCodigoProduto(int CodigoProduto){
			this.codigoProduto = CodigoProduto;
		}
		
		public void setNome(String Nome){
			this.nome = Nome;
		}
		
		public void setPreco(double Preco){
			this.preco = Preco;
		}

		public void setPrecoDeVenda(double PrecoDeVenda){
			this.precoDeVenda = PrecoDeVenda;
		}
		
		public void setPrecoDeCompra(double PrecoDeCompra){
			this.precoDeCompra = PrecoDeCompra;
		}

		public void setMarca(String Marca){
			this.marca = Marca;
		}

		public void setModelo(String Modelo){
			this.modelo = Modelo;
		}

		public void setCor(String Cor){
			this.cor = Cor;
		}

		public int getCodigoProduto(){
			return codigoProduto;
		}
		
		public String getNome(){
			return nome;
		}
		
		public double getPreco(){
			return preco;
		}
		
		public double getPrecoDeVenda(){
			return precoDeVenda;
		}

		public double getPrecoDeCompra(){
			return precoDeCompra;
		}

		public String getMarca(){
			return marca;
		}
		
		public String getModelo(){
			return modelo;
		}
	
	    public String getCor(){
			return cor;
		}

	    public void criar() {
	    	ProdutoDAO dao = new ProdutoDAO();
	    	ProdutoTO to = new ProdutoTO();
	    to.setCodigoProduto(codigoProduto);
	    to.setNome(nome);
	    to.setPreco(preco);
	    to.setPrecoDeVenda(precoDeVenda);
	    to.setPrecoDeCompra(precoDeCompra);
	    to.setMarca(marca);
	    to.setModelo(modelo);
	    to.setCor(cor);
	    dao.incluir(to);
	   
	    }
	   
	    public void atualizar() {
	    	ProdutoDAO dao = new ProdutoDAO();
	    ProdutoTO to = new ProdutoTO();
	    to.setCodigoProduto(codigoProduto);
	    to.setNome(nome);
	    to.setPreco(preco);
	    to.setPrecoDeVenda(precoDeVenda);
	    to.setPrecoDeCompra(precoDeCompra);
	    to.setMarca(marca);
	    to.setModelo(modelo);
	    to.setCor(cor);
	    dao.atualizar(to);
	    }
	   
	    public void excluir() {
	    	ProdutoDAO dao = new ProdutoDAO();
	    	ProdutoTO to = new ProdutoTO();
	    to.setCodigoProduto(codigoProduto);
	    dao.excluir(to);
	    }
	   
	    public void carregar() {
	    ProdutoDAO dao = new ProdutoDAO();
	    ProdutoTO to = dao.carregar(codigoProduto);
	    codigoProduto = to.getCodigoProduto();
	    nome  =  to.getNome();
	    preco = to.getPreco();
	    precoDeVenda = to.getPrecoDeVenda();
	    precoDeCompra = to.getPrecoDeCompra();
	    marca = to.getMarca();
	    modelo = to.getModelo();
	    cor = to.getCor();
	    }
		
	    public String toString() {
	    return "Produto [codigo=" + codigoProduto + ", nome=" + nome + ", preco=" + preco + ", PrecoDeVenda=" + precoDeVenda + ", PrecoDeCompra=" + precoDeCompra +  ", Marca=" + marca + ", Modelo=" + modelo + ", Cor=" + cor + "]";
	    }
	    
}
