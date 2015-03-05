package keepword;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class RepositorioImpl extends UnicastRemoteObject implements Repositorio{
	
	ArrayList<String> palavras; 

	protected RepositorioImpl() throws RemoteException {
		super();
		palavras = new ArrayList<String>();
	}

	@Override
	public void armazenarPalavra(String palavra){
		if(!verificarPalavra(palavra)){
			palavras.add(palavra);
		}
	}

	@Override
	public boolean verificarPalavra(String palavra) {
		boolean possuiPalavra = false;
		for (String palavra1 : palavras) {
			if(palavra1 == palavra){
				possuiPalavra = true;
			}
		}
		return possuiPalavra;
	}

	public static void main(String[] args) {
		try {
			
			RepositorioImpl repositorio = new RepositorioImpl();
			Naming.bind(args[0], repositorio);
			
		} catch (MalformedURLException | RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}		
	}
}
