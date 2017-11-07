package lab_02;

import java.util.ArrayList;

/**
* Representação de uma conta da Cantina de um aluno matriculado da UFCG, especificamente de
* computação.
*
* @author Áxel Medeiros
*/

public class ContaCantina {
	private String nomeCantina;
	private double debitoConta;
	private int qtnItensConsumidos;
	private ArrayList<String> detalhesLanches;
	
	
	 /**
	   * Constrói uma Conta da Cantina a partir do nome do estabelecimento.
	   * 
	   * @param nome string representando o nome
	 */
	
	public ContaCantina(String nome) {
		this.setNomeCantina(nome);
		this.detalhesLanches = new ArrayList<String>();
	}
	
	/**
	   *Retorna o nome da cantina relacionado com uma conta.
	   *
	   *@return String que representa o nome da cantina.
	 */
	
	public String getNomeCantina() {
		return nomeCantina;
	}
	
	
	/**
	   *Metodo que representa do cadastro do nome para uma conta de cantina.
	   *
	   *@param nomeCantina String que representa o nome da cantina.
	 */
	
	public void setNomeCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}
	
	/**
	   *Metodo representando o cadastrar a comprar de um lanche na conta.
	   *
	   *@param qtn int a quantidade de lanches pedidos.
	   *@param valor int que representa o valor total da compra.
	*/
	
	public void cadastraLanche(int qtn, int valor) {
		this.debitoConta += valor;
		this.qtnItensConsumidos += qtn;
	}
	
	/**
	   *Metodo representando o cadastrar a comprar de um lanche na conta.
	   *
	   *@param qtn int a quantidade de lanches pedidos.
	   *@param valor int que representa o valor total da compra.
	   *@param detalhe String que representa a observações feitas pelo
	   *comprador referentes ao lanche.
	*/
	
	public void cadastraLanche(int qtn, int valor, String detalhe) {
		this.debitoConta += valor;
		this.qtnItensConsumidos += qtn;
		this.detalhesLanches.add(detalhe);
	}
	
	/**
	   *Metodo representando o pagamento do débito com cantina.
	   *
	   *@param valorDebitado int que representa a ser decrementado do débito da conta.
	 */
	
	public void pagaConta(int valorDebitado) {
		this.debitoConta -= valorDebitado;
		
	}
	
	/**
	   *Retorna uma String que representa as obvervações feita do clinte referente
	   *aos últimos 5 lanches consumidos.
	   *
	   *@return String contendo todos os ultimos 5 comentários dos lanches.
	 */
	
	public String listarDetalhes(){
		String saida = percorrerDetalhes(this.detalhesLanches.size());
		return saida;
	}
	
	/**
	   *Metodo boleano que compara se dois objetos da classe são iguais utilizando como
	   *paramentro o nome de cada um deles.
	   *
	   *@parm Representando outra instancia da classe disciplina
	   *
	   *@return um Bolean que representa se os objetos são iguais ou não.
	 */
	
	@Override
	public boolean equals(Object obj){
		ContaCantina outro = (ContaCantina) obj;
		return this.nomeCantina.equals(outro.getNomeCantina());
	}
	
	/**
	   *Retorna uma String que representa o nome, quantidades de itens consumidos
	   *e o debito referentes a uma conta da cantina.
	   *
	   *@return String representando as principais informações da cantina.
	 */
	
	@Override
	public String toString(){
		int debito = (int) this.debitoConta;
		return (this.getNomeCantina() + " " + qtnItensConsumidos+ " " + debito);
	}
	
	/**
	 * Retorna uma String contendo os ultimos 5 comentários feitos pelo aluno
	 * a lanches da cantina.
	 * 
	 * @param tam_lista int que representa o tamanho da array lista de detalhes.
	 * 
	 * @return uma String contendo os ultimos comentários de lanches do aluno.
	 */
	
	private String percorrerDetalhes(int tam_lista){
		String saida = "";
		
		int cond_parada = 0;
		for (int i = tam_lista - 1; i > -1; i--) {
			if(cond_parada == 4){
				saida += this.detalhesLanches.get(i);
				break;
			}
			
			saida += this.detalhesLanches.get(i) + ", ";
			cond_parada += 1;
		}
		
		return saida;
	}

}

