package exceptions;

public class ViagemOnibusNaoExisteException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 7359528386051497682L;
	private String codigo;

	public ViagemOnibusNaoExisteException(String codigo) {
		super("A viagem de onibus de codigo" + codigo + "não existe");
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}


}
