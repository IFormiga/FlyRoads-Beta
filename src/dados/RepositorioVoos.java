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

import negocio.Voo;
public class RepositorioVoos implements IRepositorioVoo, Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -2604871904586577744L;
	private List<Voo> listaVoos;
	private static RepositorioVoos instance;

	//lista de passageiros pra usar nas regras de negocio

	private RepositorioVoos(){
		this.listaVoos = new ArrayList<Voo>();
	}

	public static RepositorioVoos getInstance(){
	    if (instance == null) {
		      instance = new RepositorioVoos();
		      instance = lerDoArquivo();
		    }
		    return instance;
	}

	public boolean cadastrar(Voo voo){
		try{
			listaVoos.add(voo);
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
	public boolean remover(String codigoDoVoo){
		String cod;
		boolean r = false;
		for(Voo voo2 : listaVoos){
			cod = voo2.getCodigoDoVoo();
			if(cod.equals(codigoDoVoo)){
				listaVoos.remove(voo2);
				r = true;
			}
		}
		return r;
	}
	public List<Voo> listar(){
		return Collections.unmodifiableList(this.listaVoos);
	}

	public Voo procurar(String codigoDoVoo){
		String cod;
		Voo r = null;
		for(Voo voo2 : listaVoos){
			cod = voo2.getCodigoDoVoo();
			if(cod.equals(codigoDoVoo)){
				r = voo2;
			}
		}
		return r;
	}

	public boolean existe(String codigoDoVoo){
		String cod;
		boolean r = false;
		for(Voo voo2 : listaVoos){
			cod = voo2.getCodigoDoVoo();
			if(cod.equals(codigoDoVoo)){
				r = true;
			}
		}
		return r;
	}

	public boolean verificaHorario(Voo v){
		boolean verificacao = false;
		for(Voo voo : listaVoos){
			if((v.getOrigem().equals(voo.getOrigem()) && v.getSaida().equals(voo.getSaida())) || (v.getDestino().equals(voo.getDestino()) && v.getChegada().equals(voo.getChegada()))){
				verificacao = true;
			}
		}
		return verificacao;
	}

	public boolean alterar(Voo voo) {
		ArrayList<Voo> listaRemovidos = new ArrayList<Voo>();
		boolean alt = false;
			for(Voo voo2 : this.listaVoos){
				if(voo.getCodigoDoVoo().equals(voo2.getCodigoDoVoo())){
					listaRemovidos.add(voo2);
							alt = true;
				}
			}
		if(alt==true){
		listaVoos.removeAll(listaRemovidos);
		listaVoos.add(voo);
		}
		return alt;
	}

	public void salvarArquivo() {

		if (instance == null) {
		      return;
		    }

		    File arqVoos = new File("RepositorioVoos.dat");
		    FileOutputStream fos = null;
		    ObjectOutputStream oos = null;

		    try {
		      fos = new FileOutputStream(arqVoos);
		      oos = new ObjectOutputStream(fos);
		      oos.writeObject(instance);
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      if (oos != null) {
		        try {
		          oos.close();
		        } catch (IOException e) {
		          }
		      }
		    }
		  }

	private static RepositorioVoos lerDoArquivo(){
		RepositorioVoos instanciaLocal = null;

	    File arqVoos = new File("RepositorioVoos.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(arqVoos);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioVoos) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioVoos();
	    } finally {
	      if (ois != null) {
	        try {
	          ois.close();
	        } catch (IOException e) {
	        }
	      }
	    }

	    return instanciaLocal;
	  }


}
