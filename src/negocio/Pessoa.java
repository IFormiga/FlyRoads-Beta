package negocio;

abstract class Pessoa extends Entidade{
	/**
	 *
	 */
	private static final long serialVersionUID = 626728217028800789L;
	private String nome;
	private String cpf;
	private	String idade;
	private String endere�o;
	private String sexo;

	public Pessoa(String nome, String cpf, String idade, String endere�o, String sexo){
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endere�o = endere�o;
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
	public String getEndere�o(){
		return this.endere�o;
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
	public void setEndere�o(String endere�o){
		this.endere�o = endere�o;
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
		if (endere�o == null) {
			if (other.endere�o != null)
				return false;
		} else if (!endere�o.equals(other.endere�o))
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
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", endere�o=" + endere�o + ", sexo="
				+ sexo + "]";
	}

}
