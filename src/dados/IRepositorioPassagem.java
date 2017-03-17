package dados;

import java.util.List;

import negocio.Passagem;

public interface IRepositorioPassagem {

	public abstract boolean cadastrar(Passagem passagem);

	public abstract boolean alterar(Passagem alterado);

	public abstract List<Passagem> listar();
	
	public abstract boolean existe(String codigo);

	public abstract Passagem procurar(String codigo);

	public abstract boolean remover(String codigo);

}