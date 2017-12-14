import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.ArrayList;


public class Cenario {

	private String descricao;
	private ArrayList<Aposta> conjuntoApostas;
	private boolean estaTerminado;
	private boolean resultadoCenario;

	
	public Cenario(String descricao){
		tratarExcecoesContrutor(descricao);
		
		this.descricao = descricao;
		this.conjuntoApostas = new ArrayList<Aposta>();
		this.estaTerminado = false;
	}
	
	public String getDescricao(){
		return this.descricao;
	}

	public int getNumApostas() { return this.conjuntoApostas.size(); }

	public void setResultadoCenario(boolean resultadoCenario) {
	    this.resultadoCenario = resultadoCenario;
	    this.estaTerminado = true;
	}



	public boolean adicionarAposta(Aposta aposta){
		this.conjuntoApostas.add(aposta);
		return true;
	}

	public String exibeApostas(){
		String saida = "";
		for (Aposta aposta: this.conjuntoApostas) {
			saida += aposta.toString() + "\n";
		}

		if (saida.equals("")) { saida = "Nenhuma aposta cadastrada"; }

		return saida;
	}

	public double getValorTotalApostas(){
		double valorTotal = 0;
		for (Aposta aposta: this.conjuntoApostas) {
			valorTotal += aposta.getQtnAposta();
		}

		return valorTotal;
	}

	public double valorRecolhido(){
	    double valorRecolhido = 0;

	    for (Aposta aposta : this.conjuntoApostas){

	        if ((this.resultadoCenario == true && aposta.getPrevisao() == false)
                    || (this.resultadoCenario == false && aposta.getPrevisao() == true)){

                valorRecolhido += aposta.getQtnAposta();

            }

        }

        return valorRecolhido;
    }

	//TODO falta a porcaria de fechar cenario


	public String toString(int numeracao){
		String estado = "";
		if (this.estaTerminado == false) {
			estado = "Não finalizado";
		}else if (this.resultadoCenario == true) {
			estado = "Finalizado (ocorreu)";
		}else{
			estado = "Finalizado (n ocorreu)";
		}
		
		return String.format("%d - %s - %s", numeracao, this.descricao, estado);
	}

	private void tratarExcecoesContrutor(String descricao){
		if (descricao.equals(null)) {
			throw new NullPointerException("Descricao nula");
		}else if (descricao.equals("")) {
			throw new IllegalArgumentException("Descrisao inválida");
		}
	}

	private double calculaFinancas(){
	    double caixaTotal = 0;
	    for (Aposta aposta: conjuntoApostas){
	        caixaTotal += aposta.getQtnAposta();
        }

        return caixaTotal;
    }

}
