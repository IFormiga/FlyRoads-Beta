package negocio;

import java.util.List;

import dados.IRepositorioPassagem;
import exceptions.PassagemJaExisteException;
import exceptions.PassagemNaoExisteException;

public class ControladorPassagem {
	private IRepositorioPassagem repositorio;

	public ControladorPassagem(IRepositorioPassagem instanciaRepositorio){
		this.repositorio = instanciaRepositorio;
	}
	public void venderPassagem(Passagem p) throws PassagemJaExisteException {
		if (p != null && (this.repositorio.existe(p.getCodigo())) == false){
	        this.repositorio.cadastrar(p);
	        this.repositorio.salvarArquivo();
	      }
	      else {
	    	  if(p == null){
	    		  IllegalArgumentException x = new IllegalArgumentException("");
	    		  throw x;
	    	  }
	    	  else{
	    		  PassagemJaExisteException z = new PassagemJaExisteException(p.getCodigo());
	    		  throw z;
	    	  }
	      }
	}
	public void alterarPassagem(Passagem passagemAlterada) throws PassagemNaoExisteException {
		boolean r;
		if(passagemAlterada != null){

			r = this.repositorio.alterar(passagemAlterada);
			this.repositorio.salvarArquivo();
			if(r==false){
				PassagemNaoExisteException z = new PassagemNaoExisteException(passagemAlterada.toString());
	    		throw z;
			}
		}
		else{
			if(passagemAlterada == null){
	    		  IllegalArgumentException x = new IllegalArgumentException("");
	    		  throw x;
			}
		}
	}
	public Passagem procurarPassagem(String cod) throws PassagemNaoExisteException {
		Passagem passagem = null;
		if(this.repositorio.existe(cod) == true){
			passagem = this.repositorio.procurar(cod);
			}
			else{
				throw new PassagemNaoExisteException(cod);
			}
		return passagem;
	}
	public List<Passagem> listaPassagens(){
		return this.repositorio.listar();
	}
	public void removerPassagem(Passagem p) throws PassagemNaoExisteException, PassagemJaExisteException {
		 if (p == null) {
		    }
		  else {
		      if (this.repositorio.existe(p.getCodigo()) == false) {
		        this.repositorio.remover(p.getCodigo());
		        this.repositorio.salvarArquivo();
		      }
		      else {
		    	  throw new PassagemJaExisteException(p.getCodigo());
		      }
		    }
	}

}
