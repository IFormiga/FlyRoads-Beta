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
import java.util.List;

import negocio.Empresa;
import negocio.ViagemOnibus;




public class RepositorioEmpresa implements IRepositorioEmpresa, Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = -7021153846651164467L;
	private List<Empresa> listaEmpresa;
	private static RepositorioEmpresa instancia;

	private RepositorioEmpresa(){
            this.listaEmpresa = new ArrayList<Empresa>();
	}

	public static RepositorioEmpresa getInstance() {

		if(instancia == null){
			instancia = new RepositorioEmpresa();
			instancia = lerDoArquivo();
		}
	    return instancia;
	  }

	public void inserir(Empresa empresa1){
	   	if(empresa1 != null){
           if(listaEmpresa.contains(empresa1) == false){
        	   listaEmpresa.add(empresa1);

           }

	   	}
	}

	public void deletar(Empresa empresa1)
	{
	    if(empresa1!= null && listaEmpresa.contains(empresa1))
			{
	    	    listaEmpresa.remove(empresa1);

			}

	}

	public Empresa procurar(String cnpj){
		String cnpj2;
		Empresa r = null;
		for(Empresa empresa2 : this.listaEmpresa){
			cnpj2 = empresa2.getCnpj();
			if(cnpj2.equals(cnpj)){
				r = empresa2;
			}
		}

		return r;
	}

	public boolean atualizar(Empresa empresa) {
		ArrayList<Empresa> listaRemovidos = new ArrayList<Empresa>();
		boolean alt = false;
			for(Empresa empresa2 : this.listaEmpresa){
				if(empresa.getCnpj().equals(empresa2.getCnpj())){
					listaRemovidos.add(empresa2);
							alt = true;
			}
		}
		this.listaEmpresa.removeAll(listaRemovidos);
			this.listaEmpresa.add(empresa);
				return alt;
	}

	public boolean existe(String cnpj) {
		boolean r = false;
		String cnpj2;
		for(Empresa empresa2 : this.listaEmpresa){
			cnpj2 = empresa2.getCnpj();
			if(cnpj2.equals(cnpj)){
				r = true;
			}
		}
		return r;
	}

	public List<Empresa> listar(){
		return Collections.unmodifiableList(this.listaEmpresa);
	}

	private static RepositorioEmpresa lerDoArquivo(){
		RepositorioEmpresa instancia = null;

		File arqviempresa = new File("RepositorioEmpresa.dat");
		FileInputStream fis = null;
		ObjectInputStream obis = null;

		try {
			fis = new FileInputStream(arqviempresa);
			obis = new ObjectInputStream(fis);
			instancia = (RepositorioEmpresa) obis.readObject();

		} catch (Exception e) {
			instancia = new RepositorioEmpresa();
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
		if (instancia == null) {
		      return;
		    }
		File arq = new File("RepositorioEmpresa.dat");
		FileOutputStream fos = null;
		ObjectOutputStream opst = null;
		try {

			fos = new FileOutputStream(arq);
			opst = new ObjectOutputStream(fos);
			opst.writeObject(instancia);



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

