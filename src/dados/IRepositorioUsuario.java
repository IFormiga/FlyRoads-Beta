package dados;

import java.util.List;

import negocio.Usuario;

public interface IRepositorioUsuario {

	public abstract boolean cadastrar(Usuario user);

	public abstract boolean alterar(Usuario alterado);

	public abstract boolean remover(String cpf);

	public abstract Usuario procurar(String cpf);

	public abstract boolean existe(String cpf);

	public abstract List<Usuario> lista();

	public void salvarArquivo();

}
