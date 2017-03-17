package dados;

import java.util.List;

import negocio.Empresa;

public interface IRepositorioEmpresa {

	public abstract void inserir(Empresa empresa1);

	public abstract void deletar(Empresa empresa1) ;

	public abstract Empresa procurar(String nomeDaEmpresa,String cnpj); //TODO mudar o nome das variaveis tirar o "_" e o abstract � irrelevante

	public abstract boolean existe(String cnpj);

	public abstract boolean atualizar(Empresa empAlt); //TODO Apenas com o objeto da entidade j� d� pra alterar. Mudar em todos os c�digos

	public abstract List<Empresa> listar();

	public void salvarArquivo();

}