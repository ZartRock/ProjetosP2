import static org.junit.Assert.assertEquals;

/**
 * Representação de um contato possuindo informações do nome, sobrenome,
 * telefone do contato.
 * 
 * @author Áxel Medeiros
 */

public class Contato {
	private String nomeContato;
	private String sobrenomeContato;
	private String telefoneContato;

	/**
	 * Representa a construção de um objeto ddo tipo Contato, como nome,
	 * sobrenome e telefone referentes a um Contato
	 * 
	 * @param nomeContato
	 *            representa o nome do contato.
	 * @param sobrenomeContato
	 *            representa o sobrenome do contato.
	 * @param telefoneContato
	 *            representa o telefone do contato
	 */

	public Contato(String nomeContato, String sobrenomeContato,
			String telefoneContato) {
		if (nomeContato == null || sobrenomeContato == null
				|| telefoneContato == null) {
			throw new NullPointerException(
					"Nome/Sobrenome/telefone de contato nulo");
		}
		if (nomeContato.equals("") || sobrenomeContato.equals("")
				|| telefoneContato.equals("")) {
			throw new IllegalArgumentException("Valores de contatos inválidos");
		}

		this.nomeContato = nomeContato;
		this.sobrenomeContato = sobrenomeContato;
		this.telefoneContato = telefoneContato;
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
	
	/**
	 * Retorna uma string com as princiais informações do contato.
	 * @return String contendo o nome e sobrenome do contato.
	 */
	public String verContato() {
		return String.format("%s %s", this.nomeContato, this.sobrenomeContato);
	}

	/**
	 * Representa a saida em uma String de todas as informações sobre o contato.
	 * 
	 * @return string contem nome, sobrenome e telefone de um contato
	 */

	public String verDetalhesContato() {
		return String.format("%s %s - %s", this.nomeContato,
				this.sobrenomeContato, this.telefoneContato);
	}

	/**
	 * Sobreescrita do metodo equals, onde agora deverá considerar dois contato
	 * como iguais se, e somente se, tiverem as mesmas informações de nome,
	 * sobrenome e telefone.
	 * 
	 * @param obj
	 * Representa outro objeto dessa mesma classe.
	 * 
	 * @return um boolean que representa se os objetos são iguais ou não.
	 */
	@Override
	public boolean equals(Object obj) {
		Contato outro = (Contato) obj;

		if ((this.nomeContato.equals(outro.getNomeContato()))
				&& (this.sobrenomeContato.equals(outro.getSobrenomeContato()))
				&& (this.telefoneContato.equals(outro.getTelefoneContato()))) {

			return true;

		}

		return false;
	}
}
