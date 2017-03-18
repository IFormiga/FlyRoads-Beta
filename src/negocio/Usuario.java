package negocio;

public class Usuario extends Pessoa {
	/**
	 *
	 */
	private static final long serialVersionUID = -8874169861904654757L;

	private String senha;
	private String dicaSenha;
	private boolean usuarioMestre = false;
	protected static String senhaMestre = "123456";

	public Usuario(String nome, String cpf, String idade, String endereço, String sexo, String senha, String dicaSenha){
		super(nome,cpf,idade,endereço,sexo);

		this.senha = senha;
		this.verificaHierarquia(senha);
		this.setDica(dicaSenha);
	}
	private void verificaHierarquia(String senha){
		boolean r = false;
		if(senha.equals(Usuario.senhaMestre)){
		r = true;
		}
		this.usuarioMestre = r;
	}
	public boolean getConfirmacao() {
		return this.usuarioMestre;
	}

	public String getDica(){
		return this.dicaSenha;
	}

	public void setDica(String dica_de_senha){
		this.dicaSenha = dica_de_senha;
	}

	@Override
	public String toString() {
		return "Usuario [ senha=" + senha + ", dicaSenha=" + dicaSenha + ", usuarioMestre="
				+ usuarioMestre + "]";
	}


	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuarioMestre != other.usuarioMestre)
			return false;
		if (dicaSenha == null) {
			if (other.dicaSenha != null)
				return false;
		} else if (!dicaSenha.equals(other.dicaSenha))
			return false;

		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}



}
