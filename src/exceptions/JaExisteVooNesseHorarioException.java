package exceptions;

public class JaExisteVooNesseHorarioException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -8683732938398664854L;
	private String codigo;

	public JaExisteVooNesseHorarioException(String string){
		super("Já existe voo neste horário.");
		this.codigo = string;
	}

	public String getCodigo(){
		return this.codigo;
	}

}
