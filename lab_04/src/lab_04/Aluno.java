package lab_04;

public class Aluno {
	private final String nome, matricula, curso;
	
	
	public Aluno(String nome, String matricula, String curso) {
		
		
		if (nome == null || matricula == null || curso == null) {
			throw new NullPointerException("Paramentos de Aluno vazios");
		}else if (nome.equals("") || matricula.equals("") || curso.equals("")) {
			throw new IllegalArgumentException("Parametos inválidos");
		}
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", this.matricula, this.nome, this.curso);
	}

	
}
