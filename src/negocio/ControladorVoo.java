package negocio;
import exceptions.VooJaExisteException;
import exceptions.VooNaoExisteException;
import exceptions.JaExisteVooNesseHorarioException;
import java.util.List;
import dados.IRepositorioVoo;

public class ControladorVoo {
	private IRepositorioVoo repositorio;

	public ControladorVoo(IRepositorioVoo instanciaRepositorio){
		this.repositorio = instanciaRepositorio;
	}

	public void cadastrarVoo(Voo v) throws VooJaExisteException, JaExisteVooNesseHorarioException{
		boolean verificacao = false;

		if (v != null && this.repositorio.existe(v.getCodigoDoVoo()) == false) {
			if(this.repositorio.verificaHorario(v) == true){
				verificacao = true;
			}
			if(verificacao == false){
				this.repositorio.cadastrar(v);
				this.repositorio.salvarArquivo();
			}
			if(verificacao == true){
				JaExisteVooNesseHorarioException m = new JaExisteVooNesseHorarioException(v.getCodigoDoVoo());
				throw m;
			}
		}
			else {
				if(v == null){
					IllegalArgumentException x = new IllegalArgumentException("");
					throw x;
				}
					else{
						VooJaExisteException z = new VooJaExisteException(v.getCodigoDoVoo());
						throw z;
					}
		      }
	}

	public void removerVoo(Voo v) /*throw VooNaoExisteException*/{
		  if (v == null) {
			  throw new IllegalArgumentException("");
		  }
		  else{
			  if (this.repositorio.existe(v.getCodigoDoVoo()) == true) {
				  this.repositorio.remover(v.getCodigoDoVoo());
				  this.repositorio.salvarArquivo();
			  }
			  else if(this.repositorio.existe(v.getCodigoDoVoo()) == false){
				  //throw new VooNaoExisteException();
			  }
		  }
	}

	public Voo procurar(String cod) throws VooNaoExisteException{
		if(this.repositorio.existe(cod) == true){
		return this.repositorio.procurar(cod);
		}
		else{
			throw new VooNaoExisteException(cod);
		}
	}

	public List<Voo> listaVoo(){
		return this.repositorio.listar();
	}

	public void alterarVoo(Voo vooAlterado, Voo voo2){
		if(vooAlterado != null && voo2 != null){
			this.repositorio.alterar(vooAlterado);
			this.repositorio.salvarArquivo();
		}
		else{
			if(vooAlterado == null || voo2 == null){
	    		  IllegalArgumentException x = new IllegalArgumentException("");
	    		  throw x;
			}
		}
	}

}


