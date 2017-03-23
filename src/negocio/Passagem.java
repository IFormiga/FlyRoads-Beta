package negocio;

import java.util.List;

public class Passagem extends Entidade{
	/**
	 *
	 */
	private static final long serialVersionUID = -66760464581900161L;
	private String codigo;
	private Usuario user;
	private String assento;
	private String pre�o;


	public String getPre�o() {
		return pre�o;
	}

	public void setPre�o(String pre�o) {
		this.pre�o = pre�o;
	}

	public Passagem(String pre�o, String codigo,Usuario user,String assento){
		this.pre�o = pre�o;
		this.codigo = codigo;
		this.user = user;
		this.assento = assento;
	}

	public String getAssento(){
		return this.assento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passagem [pre�o= "+pre�o+" codigo=" + codigo + ", user=" + user + "]";
	}

}
