package negocio;

public class PassagemOnibus extends Passagem {

	private ViagemOnibus viagem;

	public PassagemOnibus(String codigo, Usuario user, String assento,ViagemOnibus viagem) {
		super(codigo, user, assento);
		this.viagem = viagem;

	}

	public ViagemOnibus getViagem() {
		return viagem;
	}

	public void setViagem(ViagemOnibus viagem) {
		this.viagem = viagem;
	}

	public boolean equals(ViagemOnibus viagem){
		boolean verifica = false;
		if(this.getAssento().equals(viagem.getAssentos()) && this.getCodigo().equals(viagem.getCodigo()))
			verifica = true;
		return verifica;
	}

	@Override
	public String toString() {
		return super.toString() + "PassagemOnibus [viagem=" + viagem + "]";
	}




}
