package negocio;

abstract class Pessoa extends Entidade{
	/**
	 *
	 */
	private static final long serialVersionUID = 626728217028800789L;
	private String nome;
	private String cpf;
	private	String idade;
	private String endereço;
	private String sexo;

	public Pessoa(String nome, String cpf, String idade, String endereço, String sexo){
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereço = endereço;
		this.sexo = sexo;
	}
	public String getNome(){
		return this.nome;
	}
	public String getCpf(){
		return this.cpf;
	}
	public String getIdade(){
		return this.idade;
	}
	public String getEndereço(){
		return this.endereço;
	}
	public String getSexo(){
		return this.sexo;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	public void setIdade(String idade){
		this.idade = idade;
	}
	public void setEndereço(String endereço){
		this.endereço = endereço;
	}
	public void setSexo(String sexo){
		this.sexo = sexo;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (endereço == null) {
			if (other.endereço != null)
				return false;
		} else if (!endereço.equals(other.endereço))
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", endereço=" + endereço + ", sexo="
				+ sexo + "]";
	}

}
