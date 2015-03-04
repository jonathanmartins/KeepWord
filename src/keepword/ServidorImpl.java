package keepword;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class ServidorImpl extends UnicastRemoteObject implements Servidor{	
	
	protected ServidorImpl() throws RemoteException {
		super();
	}

	public void armazenarPalavra(String palavra){
		//definir em qual repositorio armazenar
	}
	
	public boolean verificarPalavra(String palavra){
		return false;
	}
	
	public static void main(String[] args) {
		try {
			ServidorImpl servidor = new ServidorImpl();
			Naming.bind("servidor", servidor);
			
			Repositorio repo1 = (Repositorio) Naming.lookup("repo1");
			Repositorio repo2 = (Repositorio) Naming.lookup("repo2");
			Repositorio repo3 = (Repositorio) Naming.lookup("repo3");
			
			//add repositorios na lista
			
		} catch (MalformedURLException | RemoteException | NotBoundException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
