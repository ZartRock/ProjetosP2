package lab_02;

import java.util.ArrayList;

/**
* Representação da uma disciplina universitário voltada para o uso dos estudantes,
* direcionado para alunos de computação, na UFCG.
* 
* @author Áxel Medeiros
*/

public class Disciplina {
	private String nomeDisciplina;
	private int horasEstudo;
	private int[] pesos;
	private ArrayList<Double> notas;
	
	/**
	   * Constrói uma Disciplina a partir do nome, número de notas, pesos
	   * de uma disciplina.
	   * 
	   * @param nomeDisciplina representando o nome.
	   * @param numNotas representando o número de notas.
	   * @param pesos representando a quantidade de pesos.
	 */
	public Disciplina(String nomeDisciplina, int numNotas, int[] pesos){
		this.setNomeDisciplina(nomeDisciplina);
		this.notas = new ArrayList<Double>(numNotas);
		this.pesos = pesos;
	}
	
	/**
	   * Constrói uma Disciplina a partir do nome, número de notas
	   * de uma disciplina.
	   * 
	   * @param nomeDisciplina representando o nome.
	   * @param numNotas representando o número de notas.
	   *
	 */
	public Disciplina(String nomeDisciplina, int numNotas){
		this(nomeDisciplina, numNotas, new int[numNotas]);
		
		for (int i = 0; i < pesos.length; i++) {
			this.pesos[i] = 1;
		}		
	}
	
	/**
	   * Constrói uma Disciplina a partir do nome de uma disciplina
	   * 
	   * @param nomeDisciplina representando o nome.
	 */
	public Disciplina(String nomeDisciplina) {
		this(nomeDisciplina, 4, new int[] {1,1,1,1});	
	}
	
	
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;	
	}

	public void cadastraNota(int num_nota, double nota) {
		num_nota -= 1;
		this.notas.add(num_nota, nota);	
	}

	public boolean aprovado() {
		double media = fazerMedia(this.notas,this.pesos);
		if (media >= 7) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString(){
		int numDisciplinas = notasCadastradas(this.notas);
		double media = fazerMedia(this.notas, this.pesos);
		String notasExibidas = exibirNotas(this.notas);
		return (this.getNomeDisciplina() + " " + numDisciplinas + " " + media + " "+ notasExibidas);
	}

	private static double fazerMedia(ArrayList<Double> notas, int[] pesos){
		double media = 0;
		int somaPesos = 0;
		for (int i = 0; i < notas.size(); i++) {
			media += notas.get(i) * pesos[i];
			somaPesos += pesos[i];
		}

		return (media / somaPesos);
	}
	
	private static int notasCadastradas(ArrayList<Double> notas){
		int cont = 0;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i) != 0.0) {
				cont += 1;
			}
		}
		
		return cont;
	}
	
	private static String exibirNotas(ArrayList<Double> notas){
		String saida = "[";
		for (int i = 0; i < notas.size(); i++) {
			if (i == notas.size() - 1) {
				saida += notas.get(i) + "]";
			} else { 
				saida += notas.get(i) + ", ";
			}
		}
		
		return saida;
	}

	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	

	@Override
	public boolean equals(Object obj){
		Disciplina outro = (Disciplina) obj;
		return this.nomeDisciplina.equals(outro.getNomeDisciplina());
	}
	
}

/*
 Deveria limitar a exibir apenas 2 digitos na media no toString()
 */
