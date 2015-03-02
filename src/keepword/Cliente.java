package keepword;

public class Cliente {
	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		
		servidor.armazenarPalavra("rmi");
		servidor.armazenarPalavra("programacao distribuida");
		servidor.armazenarPalavra("java");
		
		servidor.verificarPalavra("aula");
		servidor.verificarPalavra("programacao distribuida");
	}
}
