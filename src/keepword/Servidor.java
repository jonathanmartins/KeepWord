package keepword;

import java.rmi.Remote;

public interface Servidor extends Remote{
	
	//Armazena palavra em um dos repositorios
	public void armazenarPalavra(String palavra);
	
	//Verifica se os repositorios contem ou nao determinada palavra
	public boolean verificarPalavra(String palavra);

}
