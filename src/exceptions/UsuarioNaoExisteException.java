package exceptions;

public class UsuarioNaoExisteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1043015270651658527L;
	private String cpf;

	public UsuarioNaoExisteException(String cpf){
		super("O usu�rio de cpf: "+cpf+" n�o existe");
		this.cpf = cpf;
	}
	
	public String getCpf(){
		return this.cpf;
	}

}
