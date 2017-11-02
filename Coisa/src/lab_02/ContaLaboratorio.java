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
	
	
	public ContaLaboratorio(String nome) {
		this.setNomeLaboratorio(nome);
		this.cota = 2000;
	}
	
	public ContaLaboratorio(String nome, int cota){
		this.setNomeLaboratorio(nome);
		this.cota = cota;
	}

	
	public boolean atingiuCota() {
		if (this.espacoOcupado >= cota) {
			return true;
		}
		return false;
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
