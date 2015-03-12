package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import servidor.Servidor;

public class Cliente {
	public static void main(String[] args) {
		try {
			
			Servidor servidor = (Servidor) Naming.lookup("servidor");
			
			String opcao = "";
			System.out.println("Bem-vindo ao KeepWord!");
			
			while(!opcao.equalsIgnoreCase("exit")){
				opcao = JOptionPane.showInputDialog("Digite 1 para ADICIONAR, 2 para VERIFICAR ou EXIT para sair");  
				
				if(opcao.equalsIgnoreCase("1")){
					
					String novaPalavra = JOptionPane.showInputDialog("Digite a palavra que deseja ADICIONAR");  
					System.out.println(servidor.armazenarPalavra(novaPalavra));
				
				}else if(opcao.equalsIgnoreCase("2")){
				
					String consulta = JOptionPane.showInputDialog("Digite a palavra que deseja CONSULTAR");  
					System.out.println(servidor.verificarPalavra(consulta));
				
				}else if(opcao.equalsIgnoreCase("exit")){
					
					System.out.println("Volte sempre!");
			
				}else{
				
					System.out.println("Opção invalida, escolha novamente!");				
				
				}
				
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
