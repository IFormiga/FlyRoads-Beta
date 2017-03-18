package exceptions;

public class VooJaExisteException extends Exception {

	private static final long serialVersionUID = -7407535837196238594L;
	private String codigo;

	public VooJaExisteException(String string){
		super("O voo de codigo: "+string+" já existe");
		this.codigo = string;
	}

	public String getCodigo(){
		return this.codigo;
	}

}
