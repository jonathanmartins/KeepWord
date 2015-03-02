package keepword;

import java.rmi.Remote;

public interface Repositorio extends Remote{
	
	//Armazena palavra no repositorio
	public void armazenarPalavra(String palavra);
	
	//Verifica se o repositorio contem ou nao determinada palavra
	public boolean verificarPalavra(String palavra);
	
}
