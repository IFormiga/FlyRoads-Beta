package exceptions;

public class JaExisteVooNesseHorarioException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8683732938398664854L;
	private int codigo;
	
	public JaExisteVooNesseHorarioException(int codigo){
		super("Já existe voo neste horário.");
		this.codigo = codigo;
	}

	public int getCodigo(){
		return this.codigo;
	}
	
}
