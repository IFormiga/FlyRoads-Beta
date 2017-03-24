package exceptions;

public class UsuarioJaExisteException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4607765960416309799L;
	private String cpf;

	public UsuarioJaExisteException(String cpf) {
		super("Usuario ja existe");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}


}
