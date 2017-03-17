package negocio;

public class PassagemVoo extends Passagem {

	private Voo flight;
	public PassagemVoo(String codigo, Usuario user, String assento, Voo flight) {
		super(codigo, user, assento);
		this.flight = flight;
	}
	public Voo getFlight() {
		return flight;
	}

	public boolean equals(PassagemVoo passagem) {
		boolean r = false;
		if(passagem!=null){
			r = super.equals(passagem);
			if(passagem.getFlight().equals(passagem.getFlight())){
				r = true;
			}
		}
		return r;
	}
	
}
