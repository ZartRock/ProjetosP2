package lab_04;

/**
 * Representa um aluno matriculado em uma universidade qualquer.
 * 
 * @author Áxel Medeiros
 * 
 */
public class Aluno {
	private final String nome, matricula, curso;
	
	/**
	 * Constroir um objeto do tipo Aluno. 
	 * @param nome
	 * 	representa o nome do aluno.
	 * @param matricula
	 * 	representa  matrícula do aluno.
	 * @param curso
	 * 	representa o curso atual do aluno.
	 */
	
	public Aluno(String nome, String matricula, String curso) {

		if (nome == null || matricula == null || curso == null) {
			throw new NullPointerException("Paramentos de Aluno vazios");
		} else if (nome.equals("") || matricula.equals("") || curso.equals("")) {
			throw new IllegalArgumentException("Parametos inválidos");
		}
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	/**
	 * Retorna uma representação do Aluno com suas informação.
	 * 	
	 *@return retorna um String no formado "Matrícula - nome - curso".
	 */
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", this.matricula, this.nome,
				this.curso);
	}

}
