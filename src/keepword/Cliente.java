package keepword;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Cliente {
	public static void main(String[] args) {
		try {
			
			Servidor servidor = (Servidor) Naming.lookup("servidor");
			
			servidor.armazenarPalavra("rmi");
			servidor.armazenarPalavra("programacao distribuida");
			servidor.armazenarPalavra("java");
			
			servidor.verificarPalavra("aula");
			servidor.verificarPalavra("programacao distribuida");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
