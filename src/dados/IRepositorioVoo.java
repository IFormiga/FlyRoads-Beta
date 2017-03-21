package dados;

import java.util.List;

import negocio.Voo;

public interface IRepositorioVoo {

	public abstract boolean verificaHorario(Voo v);

	public abstract boolean cadastrar(Voo voo); //ok

	public abstract boolean remover(String codigoDoVoo); //ok

	public abstract List<Voo> listar(); //ok

	public abstract Voo procurar(String codigoDoVoo); //ok

	public abstract boolean existe(String codigoDoVoo);

	public abstract boolean alterar(Voo alterado); //ok

	public void salvarArquivo();

}