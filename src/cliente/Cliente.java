package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import servidor.Servidor;

public class Cliente {
	public static void main(String[] args) {
		try {
			
			Servidor servidor = (Servidor) Naming.lookup("servidor");
			
			System.out.println("client: armazenar 'rmi': " + servidor.armazenarPalavra("rmi"));
			System.out.println("client: armazenar 'programacao distribuida': " + servidor.armazenarPalavra("programacao distribuida"));
			System.out.println("client: armazenar 'java': " + servidor.armazenarPalavra("java"));
			
			System.out.println("client: buscar 'aula': " + servidor.verificarPalavra("aula"));
			System.out.println("client: buscar 'java': " + servidor.verificarPalavra("java"));
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
