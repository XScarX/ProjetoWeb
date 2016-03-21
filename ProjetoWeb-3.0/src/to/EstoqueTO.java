package to;

public class EstoqueTO {

	private int produto;
	private int quantidade;
	
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
}
