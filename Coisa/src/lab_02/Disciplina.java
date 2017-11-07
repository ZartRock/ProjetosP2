package lab_02;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;

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
	
	 /**
	   * Função void que representa a adição de mais horas de estudos
	   * para uma matéria.
	   *
	   *@param horas representando o número de horas estudadas
	 */
	
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;	
	}
	
	/**
	   * Função void que representa o cadastro de uma determinada nota com
	   * um determinado valor.
	   *
	   *@param num_nota representando o número da nota a ser adicionada.
	   *@param nota representa o valor da nota em questão.
	 */
	
	public void cadastraNota(int num_nota, double nota) {
		num_nota -= 1;
		this.notas.add(num_nota, nota);	
	}
	
	/**
	   * Função boolean que realiza que retorna se uma média em uma disciplina
	   * é suficiente ou não para o aluno ser aprovado.
	   *
	   *@return a representação em boleano se o aluno foi ou não aprovado
	   *na disciplina.
	 */
	
	public boolean aprovado() {
		double media = fazerMedia(this.notas,this.pesos);
		if (media >= 7) {
			return true;
		} else {
			return false;
		}
	}
	



	/**
	   *Retorna uma String representando o nome de uma disciplina.
	   *
	   *@return uma String contendo o nome da disciplina.
	 */
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	/**
	   *Metodo que definir o nome de uma disciplina
	   *
	   *@parm String representando o novo nome da disciplina
	 */
	
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	   *Metodo boleano que compara se dois objetos da classe são iguais utilizando como
	   *paramentro o nome de cada um deles.
	   *
	   *@parm Object representando um outro objeto da classe disciplina
	   *
	   *@return um Bolean que representa se os objetos são iguais ou não.
	 */
	
	@Override
	public boolean equals(Object obj){
		Disciplina outro = (Disciplina) obj;
		return this.nomeDisciplina.equals(outro.getNomeDisciplina());
	}
	
	/**
	   * Função String que representa a saida em String com as principais informações
	   * de uma disciplina.
	   *
	   *@return a representação em String dos principais status da disciplina, como nome,
	   *número, média e notas.
	 */
	
	@Override
	public String toString(){
		NumberFormat formatacao = new DecimalFormat("#.00");
		
		int numDisciplinas = notasCadastradas(this.notas);
		double media = fazerMedia(this.notas, this.pesos);
		String notasExibidas = exibirNotas(this.notas);
		
		return (this.getNomeDisciplina() + " " + numDisciplinas + " " + 
				formatacao.format(media) + " "+ notasExibidas);
	}
	
	
	/**
	   * Função que realiza a media com base na media e pesos da disciplina
	   *
	   *@param uma ArrayList<Double> repesentando as notas de uma disciplina
	   *@param uma Array de inteiros que representa os pesos.
	   *
	   *@return a representação em Double do valor da média.
	 */
	
	private static double fazerMedia(ArrayList<Double> notas, int[] pesos){
		double media = 0;
		int somaPesos = 0;
		for (int i = 0; i < notas.size(); i++) {
			media += notas.get(i) * pesos[i];
			somaPesos += pesos[i];
		}

		return (media / somaPesos);
	}
	
	/**
	   * Retorna uma número inteiro que represeta o nº de notas cadastradas até o momento
	   * no sistema.
	   *
	   *@param ArrayList<Double> notas que representa um conjunto de notas já cadastradas
	   *
	   *@return o número de notas já cadastradas no sistema
	 */
	
	private static int notasCadastradas(ArrayList<Double> notas){
		int cont = 0;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i) != 0.0) {
				cont += 1;
			}
		}
		
		return cont;
	}
	
	/**
	   * Retorna uma String contendo a representação das notas já cadastradas no sistema
	   *
	   *@param ArrayList<Double> notas que representa um conjunto de notas já cadastradas
	   *
	   *@return uma String contendo as notas.
	 */
	
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
}

