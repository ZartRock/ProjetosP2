package lab_02;

import java.util.ArrayList;

/**
* Representação de um estudante matriculado da UFCG, especificamente de
* computação. Todo aluno precisa ter uma matrícula e é identificado unicamente
* por esta matrícula.
*
* @author Áxel Medeiros
*/

public class Aluno {
	private String nome;
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<ContaLaboratorio> contaLaboratorio;
	private ArrayList<ContaCantina> contaCantina;
	private Saude saude;
	
	/**
	   * Constrói um Aluno a partir de um nome
	   * 
	   * @param nome string representando o nome do Aluno.
	 */
	
	public Aluno(String nome){
		this.nome = nome;
		this.disciplinas = new ArrayList<Disciplina>();
		this.contaLaboratorio = new ArrayList<ContaLaboratorio>();
		this.contaCantina = new ArrayList<ContaCantina>();
		this.saude = new Saude();
		
	}
	
	/**
	   * Representa o cadastro de um nome para algum laboratorio utilizado pelo
	   * aluno.
	   * 
	   * @param nomeLaboratorio string representando o nome do laboratório.
	 */
	
	public void cadastraLaboratorio(String nomeLaboratorio){
		this.contaLaboratorio.add(new ContaLaboratorio(nomeLaboratorio));
	}

	/**
	   * Representa o cadastro de um nome para algum laboratorio utilizado pelo
	   * aluno.
	   * 
	   * @param nomeLaboratorio string representando o nome do laboratório.
	   * @param cota int representando a quantidade de cota disponível na conta.
	 */
	
	public void cadastraLaboratorio(String nomeLaboratorio, int cota){
		this.contaLaboratorio.add(new ContaLaboratorio(nomeLaboratorio, cota));
		
	}
	
	/**
	   * Representa o cadastro de um nome para algum laboratorio utilizado pelo
	   * aluno.
	   * 
	   * @param nomeLaboratorio string representando o nome do laboratório.
	   * @param cota int representando a quantidade de cota disponível na conta.
	 */
	
	public void consomeEspaco(String nomeLaboratorio, int mbytes){		
		int pos = contaLaboratorio.indexOf(new ContaLaboratorio(nomeLaboratorio));
		this.contaLaboratorio.get(pos).consomeEspaco(mbytes);
	}
	
	/**
	   * Representa a ação de liberar o espaço de uma conta utilizada pelo aluno
	   * 
	   * @param nomeLaboratorio string representando o nome do laboratório.
	   * @param mbytes int representando a quantidade em MB.
	 */
	
	public void liberaEspaco(String nomeLaboratorio, int mbytes){
		int pos = contaLaboratorio.indexOf(new ContaLaboratorio(nomeLaboratorio));
		this.contaLaboratorio.get(pos).liberaEspaco(mbytes);
	}
	
	/**
	   * Representa booleana da comparação da conta de laboratorio de um aluno
	   * atingiu a cota limite.
	   * 
	   * @param nomeLaboratorio string representando o nome do laboratório.
	   * 
	   * @return um boolean que informa se o aluno atingiu ou não a cota.
	 */
	
	public boolean atingiuCota(String nomeLaboratorio){
		int pos = contaLaboratorio.indexOf(new ContaLaboratorio(nomeLaboratorio));
		return this.contaLaboratorio.get(pos).atingiuCota();
	}
	
	/**
	   * Metodo que representa a saida com as principais informações da conta de um

	   * laboratorio vinculado a um aluno.
	   * 
	   * @param nomeLaboratorio String representando o nome do laboratório.
	   * 
	   * @return uma String com as as principais informações da conta de laboratório
	 */
	
	public String laboratorioToString(String nomeLaboratorio){
		int pos = contaLaboratorio.indexOf(new ContaLaboratorio(nomeLaboratorio));
		return this.contaLaboratorio.get(pos).toString();
	}
	
	/**
	   * Representa o cadastro de uma disciplina vinculado a um aluno.
	   * 
	   * @param nomeDisciplina String que representa o nome da disciplina.
	 */
	
	public void cadastraDisciplina(String nomeDisciplina) {
		this.disciplinas.add(new Disciplina(nomeDisciplina));
	}
	
	/**
	   * Representa o cadastro de horas  estudadas de uma aluno em
	   * uma disciplina
	   * 
	   * @param nomeDisciplina String que representa o nome da disciplina.
	   * @param horas int que representa o número de horas estudadas pelo aluno.
	 */
	
	public void cadastraHoras(String nomeDisciplina, int horas) {
		int pos = disciplinas.indexOf(new Disciplina(nomeDisciplina));
		this.disciplinas.get(pos).cadastraHoras(horas);
	}
	
	/**
	   * Representa o cadastro de nota de uma aluno em
	   * uma disciplina
	   * 
	   * @param nomeDisciplina String que representa o nome da disciplina.
	   * @param nota int representa o número da nota pelo aluno.
	   * @param valorNota Double que representa o valor da nota do aluno.
	 */
	
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		int pos = disciplinas.indexOf(new Disciplina(nomeDisciplina));
		this.disciplinas.get(pos).cadastraNota(nota, valorNota);
	}
	
	/**
	   * Representa a verificação se um aluno atingiu 7 em uma determinada disciplina.
	   * 
	   * @param nomeDisciplina String que representa o nome da disciplina.
	   * 
	   * @return Boolean que representa se o aluno foi aprovado.
	 */
	
	public boolean aprovado(String nomeDisciplina) {
		int pos = disciplinas.indexOf(new Disciplina(nomeDisciplina));
		return this.disciplinas.get(pos).aprovado();	
	}
	
	/**
	   * Retorna uma String que representa as principais informações da disciplina
	   * cursada pelo aluno.
	   * 
	   * @param nomeDisciplina String que representa o nome da disciplina.
	   * 
	   * @return String contendo as principais informações da disciplina.
	 */
	
	public String disciplinaToString(String nomeDisciplina) {
		int pos = disciplinas.indexOf(new Disciplina(nomeDisciplina));
		return this.disciplinas.get(pos).toString();
	}
	
	/**
	   * Representa o cadastro de uma cantina utilizando o nome
	   * da cantina.
	   * 
	   * @param nomeCantina String que representa o nome da cantina.
	 */
	
	public void cadastraCantina(String nomeCantina) {
		this.contaCantina.add(new ContaCantina(nomeCantina));
	}
	
	/**
	   * Representa o cadastro do lanche feito pelo aluno.
	   * 
	   * @param nomeCantina String que representa o nome da cantina.
	   * @param qtdItens int que representa a quantidade de lanches pedidos.
	   * @param valorCentavos int que representa o valor total da compra em centavos.
	 */
	
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		int pos = contaCantina.indexOf(new ContaCantina(nomeCantina));
		this.contaCantina.get(pos).cadastraLanche(qtdItens, valorCentavos);
	}
	
	/**
	   * Representa o débito da conta de uma aluno com uma cantina.
	   * 
	   * @param nomeCantina String que representa o nome da cantina.
	   * @param valorCentavos int que representa o valor total da compra em centavos.
	 */
	
	public void pagarConta(String nomeCantina, int valorCentavos) {
		int pos = contaCantina.indexOf(new ContaCantina(nomeCantina));
		this.contaCantina.get(pos).pagaConta(valorCentavos);
	}
	
	/**
	   * Retorno representando a saida com as principais informações
	   * da conta de uma cantina de um aluno.
	   * 
	   * @param nomeCantina String que representa o nome da cantina.
	   * 
	   * @return uma string que contendo as principais informações.
	 */
	
	public String cantinaToString(String nomeCantina) {
		int pos = contaCantina.indexOf(new ContaCantina(nomeCantina));
		return this.contaCantina.get(pos).toString();
	}
	
	/**
	   * Representa a definição da saude mental de um aluno para um novo estado
	   * de saude.
	   * 
	   * @param estado String que representa o estado da saúde do aluno.
	 */
	
	public void defineSaudeMental(String estado) {
		this.saude.defineSaudeMental(estado);
	}
	
	/**
	   * Representa a definição da saude física de um aluno para um novo estado
	   * de saude.
	   * 
	   * @param estado String que representa o estado da saúde do aluno.
	 */
	
	public void defineSaudeFisica(String estado) {
		this.saude.defineSaudeFisica(estado);
	}
	
	/**
	   * Representa um resumo da saúde do aluno.
	   * 
	   * @return uma String que representa resumo do estado geral do aluno.
	 */
	
	public String geral() {
		return "Saude: " + this.saude.geral();
	}
	
	/**
	   * Retorna uma String que representa resumo do geral da classe Aluno.
	   * 
	   * @return uma String que representa resumo do geral da classe Aluno.
	 */
	
	@Override
	public String toString(){
		String saida = "";
		saida += this.nome;
		saida += System.lineSeparator();
		saida += geral();
		return saida;
	}
}


