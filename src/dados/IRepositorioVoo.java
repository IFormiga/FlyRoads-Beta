package dados;

import java.util.List;

import negocio.Voo;

public interface IRepositorioVoo {

	public abstract boolean verificaHorario(Voo v);

	public abstract boolean cadastrar(Voo voo); //ok

	public abstract boolean remover(int codigoDoVoo); //ok

	public abstract List<Voo> listar(); //ok

	public abstract Voo procurar(int codigoDoVoo); //ok

	public abstract boolean existe(int codigoDoVoo);
	
	public abstract void alterar(Voo alterado); //ok

}