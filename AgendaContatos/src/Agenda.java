
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contato> contatos;
	
	public Agenda(){
		this.contatos = new ArrayList<Contato>();
	}
	
	public void cadastrarContato(String nome, String sobrenome, String telefone) {
		if (contatos.size() < 100) {
			this.contatos.add(new Contato(nome, sobrenome, telefone));
		}
	}
	
}
