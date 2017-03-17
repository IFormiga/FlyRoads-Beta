package exceptions;

public class PassagemNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7983228044129530256L;
	private String codigo;

	public PassagemNaoExisteException(String codigo){
		super("A passagem de número: "+codigo+" não existe");
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}

}
