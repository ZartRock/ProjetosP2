public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;

	public Contato(String nome, String sobrenome, String telefone) {
		verificarNomesNulos(nome, sobrenome);
		if (telefone == null) {
			telefone = "Não registado";
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	public String verContato() {
		return String.format("%s %s", this.nome, this.sobrenome);
	}
	
	public String verDetalhesContato(){
		return String.format("%s %s -> %s", this.nome, this.sobrenome, this.telefone);
	}

	private void verificarNomesNulos(String nome, String sobrenome) {
		if ((nome == null) || (sobrenome == null)) {
			throw new NullPointerException("Nome/Sobrenome nulo");
		}

	}

}
