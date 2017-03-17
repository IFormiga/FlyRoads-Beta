package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import dados.IRepositorioViagensOnibus;
import exceptions.ViagemEmAndamentoException;
import exceptions.ViagemOnibusJaExisteException;
import exceptions.ViagemOnibusNaoExisteException;

public class ControladorViagemOnibus {

	private IRepositorioViagensOnibus repositorio;

	public ControladorViagemOnibus(IRepositorioViagensOnibus irep){
		this.repositorio = irep;
	}

	public boolean existe(String codigo){
		return this.repositorio.existe(codigo);
	}
	public ViagemOnibus procurar(String codigo) throws ViagemOnibusNaoExisteException{
		ViagemOnibus v1 = null;
		if(codigo == null){
			throw new IllegalArgumentException("Parametro inválido");
		}
		else if(this.repositorio.existe(codigo)){
		v1 = this.repositorio.procurar(codigo);
		}
		else{
			ViagemOnibusNaoExisteException vone = new ViagemOnibusNaoExisteException(codigo);
			throw vone;
		}
		return v1;

	}

	public List<ViagemOnibus> listar(){
		return this.repositorio.listar();
	}

	public void cadastrar(ViagemOnibus viagem) throws ViagemOnibusJaExisteException{
		if(viagem.equals(null)){
			throw new IllegalArgumentException("Parâmetro inválido");
		}
		else if(this.existe(viagem.getCodigo()) == false){
			this.repositorio.cadastrar(viagem);
			this.repositorio.salvarArquivo();


		}
		else
		{
			ViagemOnibusJaExisteException voee = new ViagemOnibusJaExisteException(viagem.getCodigo());
			throw voee;
		}
	}

	// Adicionar exception de Viagem não existe
	public void descadastrar(String codigo) throws ViagemEmAndamentoException, ViagemOnibusNaoExisteException{
		ViagemOnibus v1 = this.repositorio.procurar(codigo);

		if(codigo == null){
			throw new IllegalArgumentException("Parâmetro inválido");
		}
		else if(v1.getChegada().isAfter(LocalTime.now()) && v1.getDatachegada().isAfter(LocalDate.now()) ){

			ViagemEmAndamentoException vae = new ViagemEmAndamentoException(codigo);
			throw vae;
		}
		else if(this.repositorio.existe(codigo) == false){
			ViagemOnibusNaoExisteException vone = new ViagemOnibusNaoExisteException(codigo);
			throw vone;
		}
		else{
			this.repositorio.remover(v1);
			this.repositorio.salvarArquivo();
		}

	}

	public void alterar(ViagemOnibus v1){
		if(!v1.equals(null) && this.repositorio.existe(v1.getCodigo())== true){
			this.repositorio.alterar(v1);
			this.repositorio.salvarArquivo();
		}
		else
		{
			throw new IllegalArgumentException("Parametro inválido");
		}

	}




}
