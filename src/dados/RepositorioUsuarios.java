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

import negocio.Usuario;

public class RepositorioUsuarios implements IRepositorioUsuario, Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 8497070135388198494L;
	private List<Usuario> listaUsuarios;
	private static RepositorioUsuarios instance;

	private RepositorioUsuarios(){
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	public static RepositorioUsuarios getInstance(){
	    if (instance == null) {
		      instance = new RepositorioUsuarios();
		      instance = lerDoArquivo();
		    }
		    return instance;
	}

	public boolean cadastrar(Usuario user){

		try{
			this.listaUsuarios.add(user);
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
	public boolean alterar(Usuario usuario){
		boolean r = false;
		ArrayList<Usuario> listaRemovidos = new ArrayList<Usuario>();
		for(Usuario user1 : listaUsuarios){
			if(user1.getCpf().equals(usuario.getCpf())){
				listaRemovidos.add(user1);
				r = true;
			}
		}
		if(r == true){
			this.listaUsuarios.removeAll(listaRemovidos);
			this.listaUsuarios.add(usuario);
		}
		return r;
	}

	public boolean remover(String cpf){
		boolean r = false;
		for(Usuario user1 : listaUsuarios){
			if(user1.getCpf().equals(cpf)){
				listaUsuarios.remove(user1);
				r = true;
			}
		}
		return r;
	}

	public Usuario procurar(String cpf){
		Usuario user = null;
		for(Usuario user1 : listaUsuarios){
			if(user1.getCpf().equals(cpf)){
			user = user1;
			}
		}
		return user;
	}

	public boolean existe(String cpf){
		boolean r = false;
		for(Usuario user1 : listaUsuarios){
			if(user1.getCpf().equals(cpf)){
				r = true;
			}
		}
		return r;
	}

	public List<Usuario> lista(){
		return Collections.unmodifiableList(this.listaUsuarios);
	}


	public void salvarArquivo() {

		if (instance == null) {
		      return;
		    }

		    File arqUsuarios = new File("RepositorioUsuarios.dat");
		    FileOutputStream fos = null;
		    ObjectOutputStream oos = null;

		    try {
		      fos = new FileOutputStream(arqUsuarios);
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

	private static RepositorioUsuarios lerDoArquivo() {
		RepositorioUsuarios instanciaLocal = null;

	    File arqUsuarios = new File("RepositorioUsuarios.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(arqUsuarios);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioUsuarios) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioUsuarios();
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
