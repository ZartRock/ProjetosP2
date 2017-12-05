package lab_04;

import java.util.HashSet;

/**
 * Representação de um grupo de
 * 
 * @author Áxel Medeiros
 */
public class GrupoEstudo {
	private String nomeGrupo;
	private HashSet<Aluno> participantes;

	/**
	 * Contrução de um objeto do tipo GrupoEstudo, que contém um nome e um
	 * conjunto de participantes.
	 * 
	 * @param nomeGrupo
	 *            representa o nome do grupo.
	 */
	public GrupoEstudo(String nomeGrupo) {
		if (nomeGrupo == null) {
			throw new NullPointerException("Nome nulo");

		} else if (nomeGrupo.equals("")) {
			throw new IllegalArgumentException("Nome inválido");
		}

		this.nomeGrupo = nomeGrupo;
		this.participantes = new HashSet<>();
	}
	
	public int getNumParticipantes() {
		return this.participantes.size();
	}

	/**
	 * Representa a operação de adicionar um novo Aluno no grupo.
	 * 
	 * @param aluno
	 *            representa o aluno a ser adicionado no grupo.
	 * 
	 * @return Retornar um boolean representando o sucesso ou não da operação.
	 */
	public boolean alocarParticipante(Aluno aluno) {
		if (this.participantes.contains(aluno)) {
			return false;
		}

		this.participantes.add(aluno);
		return true;
	}

	/**
	 * Representa a saída de um string contendo o nome do grupo e uma lista com
	 * cada participante.
	 */
	@Override
	public String toString() {
		String saida = "Grupo: " + this.nomeGrupo + "\n" + "\n";
		saida += "Alunos do grupo " + this.nomeGrupo + ":" + "\n";
		for (Aluno aluno : this.participantes) {
			saida += aluno.toString() + "\n";
		}

		return saida.trim();
	}

	/**
	 * Retorana um hashcode baseado no nome do grupo
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}

	/**
	 * Verificar se dois objetos são iguais, operação terminado pelo nome do
	 * grupo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoEstudo other = (GrupoEstudo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equalsIgnoreCase(other.nomeGrupo))
			return false;
		return true;
	}
	
}
