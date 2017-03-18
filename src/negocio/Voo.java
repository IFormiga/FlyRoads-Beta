package negocio;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Voo extends Entidade{
	/**
	 *
	 */
	private static final long serialVersionUID = 1733529284768383149L;
	private String nomeEmpresa;
	private String codigoDoVoo;
	private LocalDateTime chegada;
	private LocalDateTime saida;
	private String origem;
	private String destino;
	private String assentos[] = {"1A","2A","3A","1B","2B","3B"};
	private int numAssentos = assentos.length;

	public Voo(int horaSaida, int minSaida, int horaChegada, int minChegada, String origem,
			String destino, int anoSaida, int mesSaida, int diaSaida, int anoChegada,
			int mesChegada, int diaChegada, String codigo, String nomeEmpresa){
		this.origem = origem;
		this.destino = destino;
		this.saida = LocalDateTime.of(anoSaida, mesSaida, diaSaida, horaSaida, minSaida);
		this.chegada = LocalDateTime.of(anoChegada, mesChegada, diaChegada, horaChegada, minChegada);
		this.codigoDoVoo = codigo;
		this.nomeEmpresa = nomeEmpresa;
	}

	public int numAssentos(){
		return this.numAssentos;
	}

	public String getCodigoDoVoo() {
		return codigoDoVoo;
	}


	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nome_empresa) {
		this.nomeEmpresa = nome_empresa;
	}

	public void setCodigoDoVoo(String codigo_do_voo) {
		this.codigoDoVoo = codigo_do_voo;
	}



	public void mostrarAssentos(){
		for(int i = 0; i<6; ++i){
			if(this.assentos[i]!=null){
				System.out.println(this.assentos[i]);
			}
		}
	}
	public boolean escolherAssento(String assento){
		boolean r = false;
		for(int i = 0; i<6; ++i){
			if(this.assentos[i].equals(assento)){
				this.assentos[i] = null;
				r = true;
			}
		}
		return r;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public LocalDateTime getChegada() {
		return chegada;
	}

	public void setChegada(LocalDateTime chegada) {
		this.chegada = chegada;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voo other = (Voo) obj;
		if (!Arrays.equals(assentos, other.assentos))
			return false;
		if (chegada == null) {
			if (other.chegada != null)
				return false;
		} else if (!chegada.equals(other.chegada))
			return false;
		if (codigoDoVoo != other.codigoDoVoo)
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (nomeEmpresa == null) {
			if (other.nomeEmpresa != null)
				return false;
		} else if (!nomeEmpresa.equals(other.nomeEmpresa))
			return false;
		if (numAssentos != other.numAssentos)
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (saida == null) {
			if (other.saida != null)
				return false;
		} else if (!saida.equals(other.saida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voo [nomeEmpresa=" + nomeEmpresa + ", codigoDoVoo=" + codigoDoVoo + ", chegada = " + chegada + ", saida="
				+ saida + ", origem = " + origem + ", destino = " + destino + ", assentos = " + Arrays.toString(assentos)
				+ ", numAssentos = " + numAssentos + "]";
	}




}