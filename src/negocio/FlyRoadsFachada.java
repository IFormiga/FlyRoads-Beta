package negocio;

import java.util.List;
import dados.RepositorioEmpresa;
import dados.RepositorioPassagens;
import dados.RepositorioUsuarios;
import dados.RepositorioViagensOnibus;
import dados.RepositorioVoos;
import exceptions.EmpresaJaExisteException;
import exceptions.EmpresaNaoExisteException;
import exceptions.JaExisteVooNesseHorarioException;
import exceptions.PassagemJaExisteException;
import exceptions.PassagemNaoExisteException;
import exceptions.ViagemEmAndamentoException;
import exceptions.ViagemOnibusJaExisteException;
import exceptions.ViagemOnibusNaoExisteException;
import exceptions.VooJaExisteException;
import exceptions.VooNaoExisteException;

public class FlyRoadsFachada implements IFlyRoads{
	private ControladorEmpresa empresas;
	private ControladorPassagem passagens;
	private ControladorVoo voos;
	private ControladorUsuario usuarios;
	private ControladorViagemOnibus viagensOnibus;

	private static IFlyRoads instance;

	private FlyRoadsFachada(){
		this.empresas = new ControladorEmpresa(RepositorioEmpresa.getInstance());
		this.passagens = new ControladorPassagem(RepositorioPassagens.getInstance());
		this.voos = new ControladorVoo(RepositorioVoos.getInstance());
		this.usuarios = new ControladorUsuario(RepositorioUsuarios.getInstance());
		this.viagensOnibus = new ControladorViagemOnibus(RepositorioViagensOnibus.getInstance());
	}

	public static IFlyRoads getInstance(){
		if(instance == null){
			instance = new FlyRoadsFachada();
		}
		return instance;
	}
	//    CADASTRAR/VENDER

	public void cadastrarEmpresa(Empresa empresa) throws EmpresaJaExisteException{
		this.empresas.cadastrar(empresa);
	}
	public void venderPassagem(Passagem passagem) throws PassagemJaExisteException{
		this.passagens.venderPassagem(passagem);
	}
	public void cadastrarVoo(Voo voo) throws VooJaExisteException, JaExisteVooNesseHorarioException{
		this.voos.cadastrarVoo(voo);
	}
	public void cadastrarUsuario(Usuario user){
		this.usuarios.cadastrarUsuario(user);
	}
	public void CadastrarViagemOnibus(ViagemOnibus viagem) throws ViagemOnibusJaExisteException{
		this.viagensOnibus.cadastrar(viagem);
	}

	//REMOVER

	public void removerEmpresa(String cnpj) throws EmpresaNaoExisteException{
		this.empresas.descadastrar(cnpj);
	}
	public void removerPassagem(Passagem passagem) throws PassagemNaoExisteException, PassagemJaExisteException{
		this.passagens.removerPassagem(passagem);
	}
	public void removerVoo(Voo v){
		this.voos.removerVoo(v);
	}

	public void removerUsuario(String cpf){
		this.usuarios.removerUsuario(cpf);
	}
	public void removerViagemOnibus(String codigo) throws ViagemEmAndamentoException, ViagemOnibusNaoExisteException{
		this.viagensOnibus.descadastrar(codigo);
	}
	//ALTERAR
	public void alterarEmpresa(Empresa e1){
		this.empresas.alterar(e1);
	}
	public void alterarPassagem(Passagem passagemAlterada, Passagem passagem) throws PassagemNaoExisteException{
		this.passagens.alterarPassagem(passagemAlterada, passagem);
	}
	public void alterarVoo(Voo vooAlterado){
		this.voos.alterarVoo(vooAlterado);
	}
	public void alterarUsuario(Usuario aSerAlterado){
		this.usuarios.alterarUsuario(aSerAlterado);
	}
	public void alterarViagemOnibus(ViagemOnibus v1){
		this.viagensOnibus.alterar(v1);
	}

	//PROCURAR
	public Empresa procurarEmpresa(String cnpj) throws EmpresaNaoExisteException{
		return this.empresas.procurar(cnpj);
	}
	public Passagem procurarPassagem(String cod) throws PassagemNaoExisteException{
		return this.passagens.procurarPassagem(cod);
	}
	public Voo procurarVoo(String cod) throws VooNaoExisteException{
		return this.voos.procurar(cod);
	}
	public Usuario procurarUsuario(String cpf){
		return this.usuarios.procurarUsuario(cpf);
	}
	public ViagemOnibus procurarViagemOnibus(String codigo) throws ViagemOnibusNaoExisteException{
		return this.viagensOnibus.procurar(codigo);
	}
	// LISTAR
	public List<Empresa> listaEmpresas(){
		return this.empresas.listar();
	}
	public List<Passagem> listaPassagens(){
		return this.passagens.listaPassagens();
	}
	public List<Voo> listaVoos(){
		return this.voos.listaVoo();
	}
	public List<Usuario> listaUsuarios(){
		return this.usuarios.listar();
	}
	public List<ViagemOnibus> listaViagensOnibus(){
		return this.viagensOnibus.listar();
	}

}
