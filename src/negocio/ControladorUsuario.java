package negocio;

import java.util.List;

import dados.IRepositorioUsuario;

public class ControladorUsuario {
	private IRepositorioUsuario repositorio;

	public ControladorUsuario(IRepositorioUsuario instanciaRepositorio){
		this.repositorio = instanciaRepositorio;
	}
	public void cadastrarUsuario(Usuario user){
		if(user!=null){
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
	public Usuario procurarUsuario(String cpf){
		return this.repositorio.procurar(cpf);
	}

}
