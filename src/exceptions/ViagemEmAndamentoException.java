package exceptions;

public class ViagemEmAndamentoException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 2764639478837647587L;
	private String codigo;

	public ViagemEmAndamentoException(String codigo) {
		super("A viagem de codigo" + codigo + "não pode ser removida, pois está em andamento");
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
