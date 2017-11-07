package lab_02;

/**
* Representação da conta para ter acesso aos laborátorios de computação(LCC's),
* direcionado para alunos de computação, na UFCG.
*
* @author Áxel Medeiros
*/
public class ContaLaboratorio {
	private String nomeLaboratorio;
	private int espacoOcupado;
	private int cota;
	
	/**
	   * Constrói uma Conta do Laboratorio a partir do nome e de uma cota de
	   * armazenamento em MB.
	   * 
	   * @param nome representando o nome do laborátorio
	   * @param cota representação da quantidade de espaço dispónivel em MB.
	 */
	
	public ContaLaboratorio(String nome, int cota){
		this.setNomeLaboratorio(nome);
		this.cota = cota;
	}
	
	/**
	   * Constrói uma Conta do Laboratorio a partir do nome com
	   * uma cota de armazemento padrão de 2000MB.
	   * 
	   * @param nome representando o nome do laborátorio.
	 */
	
	public ContaLaboratorio(String nome) {
		this(nome, 2000);
	}

	/**
	   *Retorna um boolean que representa se a conta atingiu sua
	   *cota de armazenamento.
	   *
	   *@return Boolean que representa se o espaço ocupado é maior que a cota.
	 */
	
	public boolean atingiuCota() {
		return this.espacoOcupado >= cota;
	}
	
	/**
	   *Metodo que representa atribuir um espaço consumido de armazenamento a uma
	   *conta do laboratório.
	   *
	   *@param Int que representa o espaço consumido a ser registrado na conta.
	 */
	public void consomeEspaco(int espacoConsumido) {
		this.espacoOcupado += espacoConsumido;
		
	}
	
	/**
	   *Metodo que representa liberar uma certa quantidade de armazenamento de uma
	   *conta do laborátorio.
	   *
	   *@param Int que representa a quantidade a ser liberada na conta.
	 */
	
	public void liberaEspaco(int qtn) {
		this.espacoOcupado -= qtn;
		
	}
	

	
	/**
	   *Retorna o nome do laborátorio relacionado com uma conta
	   *
	   *@return String que representa o nome do labotorio de uma conta.
	 */
	
	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}
	
	/**
	   *Retorna o nome do laborátorio relacionado com uma conta
	   *
	   *@return String que representa o nome do labotorio de uma conta.
	 */
	
	public void setNomeLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
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
		ContaLaboratorio outro = (ContaLaboratorio) obj;
		return this.nomeLaboratorio.equals(outro.getNomeLaboratorio());
	}
	
	/**
	   *Retorna uma String contendo a representação da pricipais informações da conta,
	   *como nome do laboratório, espaço ocupado e cota.
	   *
	   *@param Int que representa a quantidade a ser liberada na conta.
	 */
	
	@Override
	public String toString(){
		return (getNomeLaboratorio() + " " + espacoOcupado + "/" + cota);
	}
	
}
