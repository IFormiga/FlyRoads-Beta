package exceptions;

public class VooNaoExisteException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 742117098767381113L;
	private String codigo;

	public VooNaoExisteException(String cod){
		super("O voo de codigo: "+cod+" não existe");
		this.codigo = cod;
	}

	public String getCodigo(){
		return this.codigo;
	}

}
