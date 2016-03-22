package model;


public class Mercadoria {

	private int codigo;
	private String tipoMerc;
	private String nome;
	private int quantidade;
	private double preco;
	private String tipoNegocio;
	
	public Mercadoria (int codigo){
		setCodigo(codigo);
		
	}
	
	public Mercadoria (int codigo, String tipoMerc, String nome, int quantidade, double preco, String tipoNegocio){
		this.codigo = codigo;
		this.tipoMerc = tipoMerc;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.tipoNegocio = tipoNegocio;
	}
	
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
	
	public void criar() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCodigo(codigo);
		to.setTipoMerc(tipoMerc);
		to.setNome(nome);
		to.setQuantidade(quantidade);
		to.setPreco(preco);
		to.setTipoNegocio(tipoNegocio);
		dao.incluir(to);
	}

	public void atualizar() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCodigo(codigo);
		to.setTipoMerc(tipoMerc);
		to.setNome(nome);
		to.setQuantidade(quantidade);
		to.setPreco(preco);
		to.setTipoNegocio(tipoNegocio);
		dao.atualizar(to);
	}

	public void excluir() {
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCodigo(codigo);
		dao.excluir(to);
	}

}
