package negocio;

public class Empresa extends Entidade {

	private static final long serialVersionUID = 6599039238113579552L;


	private String nomeEmpresa;
	private String cnpj;
	private String ramo;
	private String senha;
	private String dicasenha;


	public Empresa(String nomeEmpresa, String cnpj, String ramo,String senha, String dicasenha){
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.ramo = ramo;
		this.senha = senha;
		this.dicasenha = dicasenha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDicasenha() {
		return dicasenha;
	}

	public void setDicasenha(String dicasenha) {
		this.dicasenha = dicasenha;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nome_empresa) {
		this.nomeEmpresa = nome_empresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Empresa [nomeEmpresa=" + nomeEmpresa + ", cnpj=" + cnpj + ", ramo=" + ramo + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (dicasenha == null) {
			if (other.dicasenha != null)
				return false;
		} else if (!dicasenha.equals(other.dicasenha))
			return false;
		if (nomeEmpresa == null) {
			if (other.nomeEmpresa != null)
				return false;
		} else if (!nomeEmpresa.equals(other.nomeEmpresa))
			return false;
		if (ramo == null) {
			if (other.ramo != null)
				return false;
		} else if (!ramo.equals(other.ramo))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}




}