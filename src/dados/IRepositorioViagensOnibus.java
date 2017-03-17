package dados;

import java.util.ArrayList;

import negocio.ViagemOnibus;

public interface IRepositorioViagensOnibus {

	boolean cadastrar(ViagemOnibus v1);

	boolean remover(ViagemOnibus viagem);

	java.util.List<ViagemOnibus> listar();

	boolean alterar(ViagemOnibus vParaAlterar);

	boolean existe(String codigo);

	ViagemOnibus procurar(String codigo);

	void salvarArquivo();




}