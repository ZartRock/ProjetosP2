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
	
	public Disciplina(String nomeDisciplina) {
		this.setNomeDisciplina(nomeDisciplina);
		this.notas = new ArrayList<Double>(4);	
		this.pesos = new int[4];
		for (int i = 0; i < pesos.length; i++) {
			pesos[i] = 1;
		}
		
	}
	
	public Disciplina(String nomeDisciplina, int numNotas){
		this.setNomeDisciplina(nomeDisciplina);
		this.notas = new ArrayList<Double>(numNotas);
		this.pesos = new int[numNotas];
		for (int i = 0; i < pesos.length; i++) {
			pesos[i] = 1;
		}
	}
	
	
	public Disciplina(String nomeDisciplina, int numNotas, int[] pesos){
		this.setNomeDisciplina(nomeDisciplina);
		this.notas = new ArrayList<Double>(numNotas);
		this.pesos = pesos;
		System.out.println(this.pesos);
		for (int i = 0; i < pesos.length; i++) {
			System.out.println(pesos[i]);;
		}
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
