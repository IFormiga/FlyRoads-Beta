package negocio;

import java.util.List;

import dados.IRepositorioUsuario;
import exceptions.UsuarioJaExisteException;
import exceptions.UsuarioNaoExisteException;

public class ControladorUsuario {
	private IRepositorioUsuario repositorio;

	public ControladorUsuario(IRepositorioUsuario instanciaRepositorio){
		this.repositorio = instanciaRepositorio;
	}
	public void cadastrarUsuario(Usuario user) throws UsuarioJaExisteException{
		if(user == null){
			throw new IllegalArgumentException("Paramento Invalido");

		}
		else if(this.repositorio.existe(user.getCpf())){
			UsuarioJaExisteException e = new UsuarioJaExisteException(user.getCpf());
			throw e;
		}
		else{
			this.repositorio.cadastrar(user);
			this.repositorio.salvarArquivo();
		}
	}
	public void removerUsuario(String cpf){
		if(cpf!=null){
			this.repositorio.remover(cpf);
			this.repositorio.salvarArquivo();
		}
	}
	public void alterarUsuario(Usuario user){
		if(user!=null){
			this.repositorio.alterar(user);
			this.repositorio.salvarArquivo();
		}
	}
	public List<Usuario> listar(){
		return this.repositorio.lista();
	}
	public Usuario procurarUsuario(String cpf)throws UsuarioNaoExisteException{
		if(cpf==null){
			throw new IllegalArgumentException("Paramento Invalido");
		}
		else if(this.repositorio.existe(cpf) == false){
			UsuarioNaoExisteException u = new UsuarioNaoExisteException(cpf);
			throw u;
		}
		return this.repositorio.procurar(cpf);
	}

}
