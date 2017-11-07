
public class Contato {
	private String[] nome = new String[100];
	private String[] sobrenome = new String[100];
	private String[] telefone = new String[100];
	private int posicaoLivre;

	public Contato(String nome,String sobrenome, String telefone) {
		this.nome[posicaoLivre] = nome;
		this.sobrenome[posicaoLivre] = sobrenome;
		this.telefone[posicaoLivre] = telefone;
	}
	
	public void listarContatos() {
		for (int i = 0; i < nome.length; i++) {
			System.out.println(imprimirContato(this.nome[i], this.sobrenome[i], this.telefone[i]));		
		}
	}
		
	public String verContato(int pos) {
		return imprimirContato(this.nome[pos], this.sobrenome[pos], this.telefone[pos]);
	}

	private String imprimirContato(String nome, String sobrenome, String telefone) {
		return String.format("%s %s %s", nome, sobrenome, telefone);
		
	}


}
