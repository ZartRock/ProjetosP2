/**
 * Representação de uma agenda de contato onde se limitar a ter apenas 100 contatos,
 * com cada agenda tendo informações do nome, sobrenome, telefone do contato.
 * 
 * @author Áxel Medeiros
 */

public class Agenda {
	private Contato[] contatos;

	public Agenda() {
		this.contatos = new Contato[100];
	}

	/**
	 * Represeta o cadastro de um novo contato com nome, sobrenome, telefone e
	 * uma posicao na Array Contatos.
	 * 
	 * @param nomeContato
	 *            representando o nome do contato
	 * @param sobrenomeContato
	 *            representando o sobrenome do contato
	 * @param telefoneContato
	 *            representando o telefone do contato
	 * @param posicaoContato
	 *            representando a posicao na agenda Contato.
	 *            
	 * @return um boolean que representa se o cadastro foi realizado ou não
	 */

	public boolean cadastrarContato(String nomeContato,
			String sobrenomeContato, String telefoneContato, int posicaoContato){

		
		if (verificarPosicacaoJaRegistrada(posicaoContato - 1)) {
			Contato exemplo = new Contato(nomeContato, sobrenomeContato, telefoneContato);
			if (exemplo.equals(this.contatos[posicaoContato - 1])) {
				throw new IllegalArgumentException("Contato já cadastrado");
			}
			
			throw new IllegalArgumentException("Posicao já cadastrada, por favor, tente outra.");
					
		}
		
		if ((posicaoContato < 1) || (posicaoContato > 100)) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		
		} else {
			try {
				contatos[posicaoContato - 1] = new Contato(nomeContato,
						sobrenomeContato, telefoneContato);

				return true;
			} catch (NullPointerException e) {
				throw new NullPointerException(e.getMessage());
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		}

		// return false;
	}

	/**
	 * Representa a listagem de todos os contatos pertecentes a uma agenda
	 */
	
	public String listarContatos() {
		String saida = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				String posicaoContato = (i + 1) + " - ";
				saida += String.format("%s %s\n",posicaoContato, contatos[i].verContato());
				}
		}
		
		if (saida.equals("")) {
			saida = "Nenhum contato cadastrato";
		}
		
		return saida.trim();
	}

	/**
	 * Representa a ação de exibir as informações de um determinado contato na
	 * agenda, a partida da sua posição.
	 * 
	 * @param posicaoContato
	 *            representa a posição do contato na agenda.
	 *            
	 * @return String que contem as infomações nome, sobrenome de um contato.
	 */

	public String pesquisarContato(int posicaoContato) {
		try {
			return contatos[posicaoContato - 1].verDetalhesContato();

		} catch (NullPointerException e) {
			throw new NullPointerException("Contato ainda não cadastrado!");
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Realiza a verificão se uma determinada posicão na agenda já possui
	 * cadastro
	 * 
	 * @param posicao
	 *            representa a posicao na agenda
	 *            
	 * @return Se houver contato já registrado, retorna true. Se não, false.
	 */

	private boolean verificarPosicacaoJaRegistrada(int posicao) {
		return this.contatos[posicao] != null;
		
	}

}

/*
 * posso adicionar uma atributo: private int contatoVazios;
 */