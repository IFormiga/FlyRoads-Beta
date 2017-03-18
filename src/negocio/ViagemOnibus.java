package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
//VAMOS PENSAR MELHOR NO SISTEMA DE ASSENTOS.
public class ViagemOnibus extends Entidade {
	/**
	 *
	 */
	private static final long serialVersionUID = -533762086151831264L;

	private String codigo;
	private String assento[] = {"1A","2A","3A","2B","3B"};
	private String origem;
	private String destino;
	private LocalTime saida;
	private LocalTime chegada;

	private LocalDate dataOrigem;
	private LocalDate dataChegada;
	public ViagemOnibus( String codigo, String origem, String destino, int saidaHora, int saidaMinuto,
			int chegadaHora,int chegadaMinuto,int anoSaida, int mesSaida, int diaSaida, int anoChegada,
			int mesChegada, int diaChegada) {
		super();

		this.setCodigo(codigo);
		this.setOrigem(origem);
		this.setDestino(destino);
		this.saida = LocalTime.of(saidaHora, saidaMinuto);
		this.chegada = LocalTime.of(chegadaHora, chegadaMinuto);
		this.dataOrigem = LocalDate.of(anoSaida, mesSaida, diaSaida);
		this.dataChegada = LocalDate.of(anoChegada, mesChegada, diaChegada);

	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		if(codigo != null)
		 this.codigo = codigo;
	}
	public String[] getAssentos() {
		return assento;
	}

	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		if(origem != null)
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		if(destino != null)
		this.destino = destino;
	}


	public LocalTime getSaida() {
		return saida;
	}
	public void setSaida(LocalTime saida) {
		this.saida = saida;
	}
	public LocalTime getChegada() {
		return chegada;
	}
	public void setChegada(LocalTime chegada) {
		this.chegada = chegada;
	}
	public LocalDate getDataorigem() {
		return dataOrigem;
	}
	public void setDataorigem(LocalDate dataorigem) {
		if(dataOrigem != null)
		this.dataOrigem = dataorigem;
	}
	public LocalDate getDatachegada() {
		return dataChegada;
	}
	public void setData_chegada(LocalDate dataChegada) {
		if(dataChegada != null)
		this.dataChegada = dataChegada;
	}
	@Override
	public String toString() {
		return "ViagemOnibus [ codigo=" + codigo + ", assento=" + Arrays.toString(assento)
				+ ", origem=" + origem + ", destino=" + destino + ", saida=" + saida + ", chegada=" + chegada
				+ ", data_origem=" + dataOrigem + ", data_chegada=" + dataChegada + "]";
	}

   @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViagemOnibus other = (ViagemOnibus) obj;
		if (!Arrays.equals(assento, other.assento))
			return false;
		if (chegada == null) {
			if (other.chegada != null)
				return false;
		} else if (!chegada.equals(other.chegada))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataChegada == null) {
			if (other.dataChegada != null)
				return false;
		} else if (!dataChegada.equals(other.dataChegada))
			return false;
		if (dataOrigem == null) {
			if (other.dataOrigem != null)
				return false;
		} else if (!dataOrigem.equals(other.dataOrigem))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
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


}
