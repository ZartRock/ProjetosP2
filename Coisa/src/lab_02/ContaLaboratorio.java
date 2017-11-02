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

	
	public boolean atingiuCota() {
		return this.espacoOcupado >= cota;
	}

	public void consomeEspaco(int espacoConsumido) {
		this.espacoOcupado += espacoConsumido;
		
	}

	public void liberaEspaco(int qtn) {
		this.espacoOcupado -= qtn;
		
	}
	
	@Override
	public String toString(){
		return (getNomeLaboratorio() + " " + espacoOcupado + "/" + cota);
	}

	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

	public void setNomeLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}
	
	@Override
	public boolean equals(Object obj){
		ContaLaboratorio outro = (ContaLaboratorio) obj;
		return this.nomeLaboratorio.equals(outro.getNomeLaboratorio());
	}
	
}
