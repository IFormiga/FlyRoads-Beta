package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import negocio.ViagemOnibus;

public class RepositorioViagensOnibus implements IRepositorioViagensOnibus,Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = -7967599937724774037L;
	private ArrayList<ViagemOnibus> listaviagens;
	private static RepositorioViagensOnibus instance;

	private RepositorioViagensOnibus(){
		this.listaviagens = new ArrayList<ViagemOnibus>();
	}
	public static RepositorioViagensOnibus getInstance(){
		if(instance == null){
			instance = new RepositorioViagensOnibus();
			instance = lerDoArquivo();
		}
		return instance;
	}


	/* (non-Javadoc)
	 * @see dados.IRepositorioViagensOnibus#cadastrarViagem(negocio.ViagemOnibus)
	 */
	@Override
	public boolean cadastrar(ViagemOnibus v1){
		boolean r = false;
		if(v1 != null){
		if(listaviagens.contains(v1) != true){
            listaviagens.add(v1);

            r = true;
		}

		}
		return r;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioViagensOnibus#removerViagem(java.lang.String)
	 */
	@Override
	public boolean remover(ViagemOnibus viagem){

		boolean r = false;
          if(viagem != null){
        	  this.listaviagens.remove(viagem);

        	  r = true;
				}
          	return r;
		}



	/* (non-Javadoc)
	 * @see dados.IRepositorioViagensOnibus#listarViagens()
	 */
	@Override
	public java.util.List<ViagemOnibus> listar(){
		return Collections.unmodifiableList(this.listaviagens);
	}



	/* (non-Javadoc)
	 * @see dados.IRepositorioViagensOnibus#alterarViagem(negocio.ViagemOnibus, negocio.ViagemOnibus)
	 */



	@Override
	public String toString() {
		return "RepositorioViagensOnibus [listaviagens=" + listaviagens + "]";
	}
	/* (non-Javadoc)
	 * @see dados.IRepositorioViagensOnibus#existe(java.lang.String)
	 */
	@Override
	public boolean existe(String codigo){
		boolean verifica = false;
		for (ViagemOnibus viagemOnibus : listaviagens) {
			if(viagemOnibus.getCodigo().equals(codigo)){
				verifica = true;
			}
		}
		return verifica;
	}


	/* (non-Javadoc)
	 * @see dados.IRepositorioViagensOnibus#procurar(java.lang.String)
	 */
	@Override
	public ViagemOnibus procurar(String codigo){
		ViagemOnibus resultado = null;

		for (int i = 0; i < this.listaviagens.size(); i++) {
			     if (this.listaviagens.get(i).getCodigo().equals(codigo)) {
			        resultado = this.listaviagens.get(i);
			      }
		}

		return resultado;
	}
	@Override
	public boolean alterar(ViagemOnibus viagem) {
		ArrayList<ViagemOnibus> listaRemovidos = new ArrayList<ViagemOnibus>();
		boolean alt = false;
			for(ViagemOnibus viagem2 : this.listaviagens){
				if(viagem.getCodigo().equals(viagem2.getCodigo())){
					listaRemovidos.add(viagem2);
							alt = true;
			}
		}
		if(alt==true){
			this.listaviagens.removeAll(listaRemovidos);
			this.listaviagens.add(viagem);
		}
				return alt;
	}

	private static RepositorioViagensOnibus lerDoArquivo(){
		RepositorioViagensOnibus instancia = null;

		File arqviagens = new File("RepositorioViagensOnibus.dat");
		FileInputStream fis = null;
		ObjectInputStream obis = null;

		try {
			fis = new FileInputStream(arqviagens);
			obis = new ObjectInputStream(fis);
			instancia = (RepositorioViagensOnibus) obis.readObject();

		} catch (Exception e) {
			instancia = new RepositorioViagensOnibus();
		}
		finally {
			if(obis != null){
				try {
					obis.close();
				} catch (IOException e) {
					System.out.println("Nao foi possível fechar o arquivo");
					e.printStackTrace();
				}
			}
		}
		return instancia;
	}
	public void salvarArquivo(){
		if (instance == null) {
		      return;
		    }
		File arq = new File("RepositorioViagensOnibus.dat");
		FileOutputStream fos = null;
		ObjectOutputStream opst = null;
		try {

			fos = new FileOutputStream(arq);
			opst = new ObjectOutputStream(fos);
			opst.writeObject(instance);



		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
           if(opst != null){
        	   try {
				opst.close();
			} catch (IOException  e) {
				System.out.println("Nao foi possivel fechar o arquivo");
				e.printStackTrace();
			}
           }

	}
}
}
