package keepword;

import java.awt.List;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Servidor {	
	public void armazenarPalavra(String palavra){
		//definir em qual repositorio armazenar
	}
	
	public boolean verificarPalavra(String palavra){
		return false;
	}
	
	public static void main(String[] args) {
		try {
			Repositorio repo1 = (Repositorio) Naming.lookup("repo1");
			Repositorio repo2 = (Repositorio) Naming.lookup("repo2");
			Repositorio repo3 = (Repositorio) Naming.lookup("repo3");
			
			//add repositorios na lista
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
