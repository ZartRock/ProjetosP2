import static org.junit.Assert.assertEquals;

public class Contato {
	private String nomeContato;
	private String sobrenomeContato;
	private String telefoneContato;

	public Contato(String nome, String sobrenome, String telefone) {
		verificarNomesNulos(nome, sobrenome);
		if (telefone.equals("")) {
			telefone = "Não registado";
		}
		this.nomeContato = nome;
		this.sobrenomeContato = sobrenome;
		this.telefoneContato = telefone;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public String getSobrenomeContato() {
		return sobrenomeContato;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public String verContato() {
		return String.format("%s %s", this.nomeContato, this.sobrenomeContato);
	}

	public String verDetalhesContato() {
		return String.format("%s %s -> %s", this.nomeContato, this.sobrenomeContato, this.telefoneContato);
	}

	private void verificarNomesNulos(String nome, String sobrenome) {
		if ((nome == null) || (sobrenome == null)) {
			throw new NullPointerException("Nome/Sobrenome nulo");
		}

	}

	@Override
	public boolean equals(Object obj) {
		Contato outro = (Contato) obj;
		
		if (
			(this.nomeContato.equals(outro.getNomeContato())) &&
		    (this.sobrenomeContato.equals(outro.getSobrenomeContato())) &&
		    (this.telefoneContato.equals(outro.getTelefoneContato()))){
			
			return true;
			
		}
		
		return false;
	}
}
