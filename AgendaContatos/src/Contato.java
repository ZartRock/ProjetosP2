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
	 * Sobreescrita do método hashCode
	 * 
	 * @return retorna o hashcode do objeto considerando um nome, sobrenome, telefone do contato.
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeContato == null) ? 0 : nomeContato.hashCode());
		result = prime * result + ((sobrenomeContato == null) ? 0 : sobrenomeContato.hashCode());
		result = prime * result + ((telefoneContato == null) ? 0 : telefoneContato.hashCode());
		return result;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nomeContato == null) {
			if (other.nomeContato != null)
				return false;
		} else if (!nomeContato.equals(other.nomeContato))
			return false;
		if (sobrenomeContato == null) {
			if (other.sobrenomeContato != null)
				return false;
		} else if (!sobrenomeContato.equals(other.sobrenomeContato))
			return false;
		if (telefoneContato == null) {
			if (other.telefoneContato != null)
				return false;
		} else if (!telefoneContato.equals(other.telefoneContato))
			return false;
		return true;
	}

	
}
