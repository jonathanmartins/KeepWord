package repositorio;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Repositorio extends Remote{
	
	//Armazena palavra no repositorio
	public boolean armazenarPalavra(String palavra) throws RemoteException;
	
	//Verifica se o repositorio contem ou nao determinada palavra
	public boolean verificarPalavra(String palavra) throws RemoteException;
	
	//Retorna o armazenamento atual do repositorio
	public int verificarCapacidade() throws RemoteException;
	
	public String getNome() throws RemoteException;
	
	public void setNome(String nome) throws RemoteException;
	
}
