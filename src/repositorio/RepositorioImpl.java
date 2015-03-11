package repositorio;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
public class RepositorioImpl extends UnicastRemoteObject implements Repositorio {

	ArrayList<String> palavras;
	String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	protected RepositorioImpl() throws RemoteException {
		super();
		palavras = new ArrayList<String>();
	}

	// tenta armazenar dada palavra ao repositorio, caso ela nao ja exista no
	// mesmo.
	@Override
	public boolean armazenarPalavra(String palavra) throws RemoteException {
		if (!verificarPalavra(palavra)) {
			palavras.add(palavra);
			return true;
		}
		System.out.println(getNome() + ": Palavra ja existente");
		return false;
	}

	// verifica se dada palavra existe no repositorio
	@Override
	public boolean verificarPalavra(String palavra) throws RemoteException {
		boolean possuiPalavra = false;
		Iterator<String> iterador = palavras.iterator();
		while (iterador.hasNext()) {
			if (iterador.next().equals(palavra)) {
				System.out.println(getNome() + ": palavra encontrada");
				possuiPalavra = true;
			}
		}
		return possuiPalavra;
	}

	// retorna quantas palavras ja foram adicionadas ao repositorio
	public int verificarCapacidade() throws RemoteException {
		return palavras.size();
	}

	// registra o repositorio no RMI Registry
	public boolean registrar(RepositorioImpl repo) throws RemoteException,
			MalformedURLException, AlreadyBoundException {
		Naming.bind(repo.getNome(), repo);
		System.out.println(repo.getNome() + " registrado no RMI Registry");
		return true;
	}
}
