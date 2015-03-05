package keepword;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ServidorImpl extends UnicastRemoteObject implements Servidor{	
	
	ArrayList<Repositorio> repositorios;
	
	protected ServidorImpl() throws RemoteException {
		super();
		repositorios = new ArrayList<Repositorio>();
	}

	public void armazenarPalavra(String palavra){
		//definir em qual repositorio armazenar
	}
	
	public boolean verificarPalavra(String palavra){
		//Talvez modificar esse metodo pra retornar uma string pro cliente, mostrando quais repositorios tem a palavra
		for (Repositorio repositorio : repositorios) {
			if(repositorio.verificarPalavra(palavra)){
				System.out.println("Repositorio possui palavra");
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		try {
			ServidorImpl servidor = new ServidorImpl();
			Naming.bind("servidor", servidor);
			
			Repositorio repo1 = (Repositorio) Naming.lookup("repo1");
			Repositorio repo2 = (Repositorio) Naming.lookup("repo2");
			Repositorio repo3 = (Repositorio) Naming.lookup("repo3");
			
			servidor.repositorios.add(repo1);
			servidor.repositorios.add(repo2);
			servidor.repositorios.add(repo3);
			
		} catch (MalformedURLException | RemoteException | NotBoundException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
