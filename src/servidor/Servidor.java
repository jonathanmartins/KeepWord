package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servidor extends Remote{
	
	//Armazena palavra em um dos repositorios
	public String armazenarPalavra(String palavra) throws RemoteException;
	
	//Verifica se os repositorios contem ou nao determinada palavra
	public String verificarPalavra(String palavra) throws RemoteException;

}
