package negocio;

public class Assento {
	private String assentos[] = {"1A","2A","3A","1B","2B","3B"};
	private int numAssentos = assentos.length;
	public Assento(){
	
	}
	public void imprimirDisponiveis(){
		for(int i = 0;i<this.numAssentos ;++i){
			if(this.assentos[i]!=null){
			System.out.println(this.assentos[i]);
			}
		}
	}
	public boolean escolherAssento(String assento){
		boolean r = false;
		for(int i = 0;i<this.numAssentos ;++i){
			if(this.assentos[i].equals(assento)){
			this.assentos[i] = null;
			r = true;
			}
		}
		return r;
	}
}
