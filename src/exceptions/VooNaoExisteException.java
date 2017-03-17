package exceptions;

public class VooNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 742117098767381113L;
	private int codigo;
	
	public VooNaoExisteException(int codigo){
		super("O voo de codigo: "+codigo+" não existe");
		this.codigo = codigo;
	}

	public int getCodigo(){
		return this.codigo;
	}
	
}
