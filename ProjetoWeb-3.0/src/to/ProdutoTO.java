package to;

public class ProdutoTO {
	private int codigo;
	private double precoDeVenda;
	private double precoDeCompra;
	private String marca;
	private String modelo;
	private String cor;
	
	public void setCodigo(int codigo){
		this.codigo = codigo;
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

	public int getCodigo(){
		return codigo;
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
