package lab_04;

import java.util.HashSet;

public class GrupoEstudo {
	private String nome;
	private HashSet<Aluno> participantes;

	public GrupoEstudo(String nomeGrupo) {
		if (nomeGrupo == null) {
			throw new NullPointerException("Nome nulo");

		} else if (nomeGrupo.equals("")) {
			throw new IllegalArgumentException("Nome inválido");
		}

		this.nome = nomeGrupo;
		this.participantes = new HashSet<>();
	}

	public boolean alocarParticipante(Aluno aluno) {
		if (this.participantes.contains(aluno)) {
			return false;
		}

		this.participantes.add(aluno);
		return true;
	}

	@Override
	public String toString() {
		String saida = "Grupo: " + this.nome + "\n" + "\n";
		saida += "Alunos do grupo " +this.nome + ":" + "\n";
		for (Aluno aluno : this.participantes) {
			saida += aluno.toString() + "\n";
		}

		return saida.trim();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoEstudo other = (GrupoEstudo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equalsIgnoreCase(other.nome))
			return false;
		return true;
	}

}
