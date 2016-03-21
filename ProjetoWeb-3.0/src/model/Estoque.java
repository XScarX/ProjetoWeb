package model;

import dao.EstoqueDAO;
import to.EstoqueTO;

public class Estoque {
	private int produto;
	private int quantidade;
	
	public Estoque(int p, int q){
		setProduto(p);
		setQuantidade(q);
	}
	
	public void setProduto(int p){
		this.produto = p;
	}
	
	public void setQuantidade(int q){
		this.quantidade = q;
	}
	
	public int getProduto(){
		return produto;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public void criar() {
	    	EstoqueDAO dao = new EstoqueDAO();
	    	EstoqueTO to = new EstoqueTO();
	    to.setProduto(produto);
	    to.setQuantidade(quantidade);
	  
	    dao.incluir(to);
	    }
	   
	public void atualizar() {
	   EstoqueDAO dao = new EstoqueDAO();
	   EstoqueTO to = new EstoqueTO();
	    to.setProduto(produto);
	    to.setQuantidade(quantidade);
	    
	    dao.atualizar(to);
	    }
	   
    public void excluir() {
	   EstoqueDAO dao = new EstoqueDAO();
	   EstoqueTO to = new EstoqueTO();
	    to.setProduto(produto);
	    dao.excluir(to);
	    }
	   
	public void carregar() {
		EstoqueDAO dao = new EstoqueDAO();
	    EstoqueTO to = dao.carregar(produto);
	    produto = to.getProduto();
	    quantidade  =  to.getQuantidade();
	  
	    }
		
	public String toString() {
	    return "Produto [Produto=" + produto + ", Quantidade=" + quantidade + "]";
	    }


}
