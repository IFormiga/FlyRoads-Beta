package exceptions;

public class EmpresaNaoExisteException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -2920617635291145473L;
	private String cnpj;

	public EmpresaNaoExisteException(String cnpj) {
		super("A empresa com este" +cnpj+ " não existe");
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


}
