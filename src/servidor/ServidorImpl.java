package servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import repositorio.Repositorio;

@SuppressWarnings("serial")
public class ServidorImpl extends UnicastRemoteObject implements Servidor{	
	
	ArrayList<Repositorio> repositorios;
	
	protected ServidorImpl() throws RemoteException {
		super();
		repositorios = new ArrayList<Repositorio>();
	}

	//envia palavra pro servidor que tiver menor carga atualmente
	public boolean armazenarPalavra(String palavra) throws RemoteException{
		int repo[] = new int[repositorios.size()];
		for (int x=0; x<repositorios.size(); x++){
			repo[x]=repositorios.get(x).verificarCapacidade();
		}
		int y=Integer.MAX_VALUE;
		for (int x=0; x<repo.length; x++){
			if (repo[x]<y)
				y=x;
		}
		System.out.println("menor carga no repositorio " + y);
		return repositorios.get(y).armazenarPalavra(palavra);
	}
	
	public boolean verificarPalavra(String palavra) throws RemoteException{
		//Talvez modificar esse metodo pra retornar uma string pro cliente, mostrando quais repositorios tem a palavra
		for (int x=0; x<repositorios.size(); x++) {
			if(repositorios.get(x).verificarPalavra(palavra)){
				System.out.println("servidor: Repositorio possui palavra");
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws RemoteException{
			ServidorImpl servidor = new ServidorImpl();
			//Try-Catch específico para o bind, para evitar de o servidor parar de funcionar por causa disso
		try {
			Naming.rebind("servidor", servidor);
		} catch (MalformedURLException e) {
			System.out.println("servidor: MalformedURLException");
		}
		
		/*	
		 * pesquisando repositorios online
		 */
		//TODO Fazer essa busca acontecer de tempos em tempos, para permitir que os repos sejam criados em qualquer ordem
		try {
			Repositorio repo1 = (Repositorio) Naming.lookup("repo1");
			System.out.println("lookup repo1 ok.");
//			Repositorio repo2 = (Repositorio) Naming.lookup("repo2");
//			Repositorio repo3 = (Repositorio) Naming.lookup("repo3");
			
			servidor.repositorios.add(repo1);
//			servidor.repositorios.add(repo2);
//			servidor.repositorios.add(repo3);
			
		} catch (MalformedURLException | NotBoundException e) {
			System.out.println("servidor: Erro durante busca por repositorio");
			e.printStackTrace();
		}
	}
}
