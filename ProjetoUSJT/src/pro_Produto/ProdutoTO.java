package pro_Produto;

public class ProdutoTO {
	private int codigoProduto;
	private String nome;
	private double preco;
	private double precoDeVenda;
	private double precoDeCompra;
	private String marca;
	private String modelo;
	private String cor;
	
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

}
