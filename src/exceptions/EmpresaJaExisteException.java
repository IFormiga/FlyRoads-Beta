package exceptions;

public class EmpresaJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8405190588570139839L;
	private String cnpj;

	public EmpresaJaExisteException(String cnpj) {
		super("A empresa com este" +cnpj+ " existe");
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}





}
