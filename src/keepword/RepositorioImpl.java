package keepword;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RepositorioImpl extends UnicastRemoteObject implements Repositorio{

	protected RepositorioImpl() throws RemoteException {
		super();
	}

	@Override
	public void armazenarPalavra(String palavra) {
		
	}

	@Override
	public boolean verificarPalavra(String palavra) {
		return false;
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
