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
	public String armazenarPalavra(String palavra) throws RemoteException{
		
		int capacidade[] = new int[repositorios.size()];
		for (int repo = 0; repo < repositorios.size(); repo++){
			capacidade[repo] = repositorios.get(repo).verificarCapacidade();
		}
		
		int maisVazio = Integer.MAX_VALUE;
		int escolhido = 0;
		
		for (int x=0; x < capacidade.length; x++){
			if (capacidade[x] < maisVazio){
				maisVazio = capacidade[x];
				escolhido = x;
			}
		}
		
		String resposta;
		if(repositorios.get(escolhido).armazenarPalavra(palavra)){
			resposta = "Palavra armazenada no repositorio com menor carga: "+ repositorios.get(escolhido).getNome();
			System.out.println(resposta);
		}else{
			resposta = "Essa palavra já foi armazenada!";
		}
		
		return resposta;
	}
	
	public String verificarPalavra(String palavra) throws RemoteException{
		String resposta = "";
		for (int x=0; x<repositorios.size(); x++) {
			if(repositorios.get(x).verificarPalavra(palavra)){
				System.out.println("Repositorio "+repositorios.get(x).getNome()+" possui a palavra "+palavra);
				resposta += "Palavra encontrada no repositorio: "+repositorios.get(x).getNome()+"\n";
			}
		}
		
		if(resposta.equals("")){
			resposta = "Essa palavra não foi encontrada";
		}
		
		return resposta;
	}
	
	public static void main(String[] args) throws RemoteException{
		
		ServidorImpl servidor = new ServidorImpl();
		
		//Try-Catch específico para o bind, para evitar de o servidor parar de funcionar por causa disso
		try {
			Naming.rebind("servidor", servidor);
		} catch (MalformedURLException e) {
			System.out.println("servidor: MalformedURLException");
		}
		
		//TODO Fazer essa busca acontecer de tempos em tempos, para permitir que os repos sejam criados em qualquer ordem
		try {
			Repositorio repo1 = (Repositorio) Naming.lookup("repo1");
			System.out.println("Referencia repo1 recuperada");
			Repositorio repo2 = (Repositorio) Naming.lookup("repo2");
			System.out.println("Referencia repo2 recuperada");
			Repositorio repo3 = (Repositorio) Naming.lookup("repo3");
			System.out.println("Referencia repo3 recuperada");

			
			servidor.repositorios.add(repo1);
			servidor.repositorios.add(repo2);
			servidor.repositorios.add(repo3);
			
		} catch (MalformedURLException | NotBoundException e) {
			System.out.println("servidor: Erro durante busca por repositorio");
			e.printStackTrace();
		}
	}
}
