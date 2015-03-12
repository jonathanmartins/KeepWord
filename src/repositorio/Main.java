package repositorio;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		RepositorioImpl repositorio;

		boolean sucesso = false;
		int x = 1;
		//tenta ate 5 vezes, ou ate conectar com sucesso
		while (!sucesso & x < 6) {
			try {
				repositorio = new RepositorioImpl();
				repositorio.setNome(args[0]);

				try {
					//registrar
					System.out.println("Tentando conexao n." + x);
					sucesso = repositorio.registrar(repositorio);

					//se ja tiver registrado
				} catch (AlreadyBoundException e) {
					System.out.println("Ja registrado");
					System.out.println("Nova tentativa em 10 segundos.");
					Thread.sleep(10000);
					
					//se o endereco tiver errado
				} catch (MalformedURLException e) {
					System.out.println("URL Malformada");
					System.out.println("Nova tentativa em 10 segundos.");
					Thread.sleep(10000);
				}

				//erros remotos, como o registry offline
			} catch (RemoteException e1) {
				System.out.println("Remote Exception na instanciacao do repositorio");
				System.out.println("Nova tentativa em 10 segundos.");
				Thread.sleep(10000);
			}
			x++;
		}
	}
}
