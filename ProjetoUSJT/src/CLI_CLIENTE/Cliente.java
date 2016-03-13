package CLI_CLIENTE;

public class Cliente {
	
		private int id;
		private String nome;
		private String telefone;
		private String endereco;
		private String nasc;
		
		public Cliente(int id, String nome, String telefone, String nascimento, String endereco) {
			setId(id);
			setNome(nome);
			setTelefone(telefone);	
			setEndereco(endereco);
			setNascimento(nascimento);
			setEndereco(endereco);
		}
	
		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public String getNome() {
			return nome;
		}
	
		public void setNome(String nome) {
			this.nome = nome;
		}
	
		public String getTelefone() {
			return telefone;
		}
	
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
	
		public String getEndereco() {
			return endereco;
		}
	
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		
		public String getNascimento(){
			return nasc;
		}
	
		public void setNascimento(String nascimento){
			this.nasc = nascimento;
		}
		public void criar() {
			ClienteDAO dao = new ClienteDAO();
			ClienteTO to = new ClienteTO();
			to.setId(id);
			to.setNome(nome);
			to.setTelefone(telefone);
			to.setNasc(nasc);
			to.setEndereco(endereco);
			dao.incluir(to);
		}
	
		public void atualizar() {
			ClienteDAO dao = new ClienteDAO();
			ClienteTO to = new ClienteTO();
			to.setId(id);
			to.setNome(nome);
			to.setTelefone(telefone);
			to.setNasc(nasc);
		to.setEndereco(endereco);
			dao.atualizar(to);
		}
	
		public void excluir() {
			ClienteDAO dao = new ClienteDAO();
			ClienteTO to = new ClienteTO();
			to.setId(id);
			dao.excluir(to);
		}
	
		public void carregar() {
			ClienteDAO dao = new ClienteDAO();
			ClienteTO to = dao.carregar(id);
			nome = to.getNome();
			telefone = to.getTelefone();
			nasc = to.getNasc();
			endereco = to.getEndereco();
		}
	
		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nome=" + nome + ", telefone=" + telefone + "Nascimento" + nasc + "Endereço" + endereco + "]";
		}
	}

