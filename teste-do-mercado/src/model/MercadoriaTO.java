package model;

public class MercadoriaTO {

	private int codigo;
	private String tipoMerc;
	private String nome;
	private int quantidade;
	private double preco;
	private String tipoNegocio;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipoMerc() {
		return tipoMerc;
	}

	public void setTipoMerc(String tipoMerc) {
		this.tipoMerc = tipoMerc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

}
