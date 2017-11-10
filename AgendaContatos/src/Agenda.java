
public class Agenda {
	private Contato[] contatos;
	
	public Agenda() {
		this.contatos = new Contato[100];
	}
	
	public void cadastrarContato(String nome, String sobrenome, String telefone, int posicao) {
		
		this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
	
	}
	
	public void listarContatos() {
		for (int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				System.out.println(contatos[i].verContato());
			}
		
		}
	}
	
	public void pesquisarContato(int posicaoContato) {
		if (contatos[posicaoContato] == null ) {
			System.out.println("POSIÇÃO INVÁLIDA!");
		} else {
			System.out.println(contatos[posicaoContato].verDetalhesContato());
		}
	}
	

}
	
	
/*
	posso adicionar uma atributo: private int contatoVazios;
*/