package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import negocio.Passagem;

public class RepositorioPassagens implements IRepositorioPassagem {
	private ArrayList<Passagem> listaPassagens;
	private static RepositorioPassagens instance;
	
	private RepositorioPassagens(){
		this.listaPassagens = new ArrayList<Passagem>(); 
	}
	
	public static RepositorioPassagens getInstance(){
	    if (instance == null) {
		      instance = new RepositorioPassagens();
		      instance = lerDoArquivo();
		    }
		    return instance;
	}
	
	public boolean cadastrar(Passagem passagem){
		try{
			listaPassagens.add(passagem);
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
	public boolean alterar(Passagem passagem){
		boolean r = false;
		ArrayList<Passagem> listaRemovidos = new ArrayList<Passagem>();
		for(Passagem passagem2 : this.listaPassagens){
			if(passagem2.getCodigo().equals(passagem.getCodigo())){
				listaRemovidos.add(passagem2);
				r = true;
			}
		}
		if(r == true){
			this.listaPassagens.removeAll(listaRemovidos);
			this.listaPassagens.add(passagem);
		}
		return r;
	}
	
	public List<Passagem> listar(){
		return Collections.unmodifiableList(this.listaPassagens);
	}
	
	public Passagem procurar(String codigo){
		String cod;
		Passagem r = null;
		for(Passagem passagem1 : listaPassagens){
			cod = passagem1.getCodigo();
			if(cod.equals(codigo)){
				r = passagem1;
			}
		}
		return r;
	}
	
	public boolean existe(String codigo){
		boolean r = false;
		String cod;
		for(Passagem passagem1 : listaPassagens){
			cod = passagem1.getCodigo();
			if(cod.equals(codigo)){
				r = true;
			}
		}
		return r;
	}
	
	public boolean remover(String codigo){
		String cod;
		boolean r = false;
		for(Passagem passagem1 : listaPassagens){
			cod = passagem1.getCodigo();
			if(cod.equals(codigo)){
				listaPassagens.remove(passagem1);
				r = true;
			}
		}
		return r;
	}
	
	public void salvarArquivo() {

		if (instance == null) {
		      return;
		    }

		    File arqpassagens = new File("RepositorioPassagens.dat");
		    FileOutputStream fos = null;
		    ObjectOutputStream oos = null;

		    try {
		      fos = new FileOutputStream(arqpassagens);
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
	
	private static RepositorioPassagens lerDoArquivo() {
		RepositorioPassagens instanciaLocal = null;

	    File arqpassagens = new File("RepositorioPassagens.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(arqpassagens);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioPassagens) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioPassagens();
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
