import java.util.ArrayList;


public class Cenario {

	private String descricao;
	private ArrayList<Aposta> conjuntoApostas;
	private boolean estaTerminado;
	private int resultadoCenario;
	
	
	public Cenario(String descricao){
		if (descricao.equals(null)) {
			throw new NullPointerException("Descricao nula");
		}else if (descricao.equals("")) {
			throw new IllegalArgumentException("Descrisao inválida");
		}
		
		this.descricao = descricao;
		this.conjuntoApostas = new ArrayList<Aposta>();
		this.estaTerminado = false;
		this.resultadoCenario = 10;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	public boolean adicionarAposta(Aposta aposta){
		this.conjuntoApostas.add(aposta);
		return true;
	}
	
	
	public String toString(int numeracao){
		String estado = "";
		if (this.estaTerminado == false) {
			estado = "Não finalizado";
		}else if (this.resultadoCenario == 1) {
			estado = "Finalizado (ocorreu)";
		}else{
			estado = "Finalizado (n ocorreu)";
		}
		
		return String.format("%d - %s - %s", numeracao, this.descricao, estado);
	}
}
