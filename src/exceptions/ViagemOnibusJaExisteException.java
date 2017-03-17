package exceptions;

public class ViagemOnibusJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4322557862366999372L;
	private String codigo;

	public ViagemOnibusJaExisteException(String codigo) {
		super("Ja existe a viagem de onibus de codigo:" + codigo);
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}



}
