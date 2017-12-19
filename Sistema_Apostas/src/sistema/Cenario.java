package sistema;

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

	public int valorRecolhido(){
	    int valorRecolhidoCentavos = 0;

	    for (Aposta aposta : this.conjuntoApostas){

	        if ((this.resultadoCenario == true && aposta.getPrevisao() == false)
                    || (this.resultadoCenario == false && aposta.getPrevisao() == true)){

                valorRecolhidoCentavos += aposta.getQtnAposta();

            }

        }

        return valorRecolhidoCentavos;
    }

	public void finalizarCenario(boolean resultadoCenario) throws Exception {
		if (this.estaTerminado == true){
		    throw new Exception("Erro ao fechar aposta: Cenario ja esta fechado");
        }
	    this.resultadoCenario = resultadoCenario;
		this.estaTerminado = true;
	}


	public String toString(int numeracao){
		String estado = "";

		if (this.estaTerminado == false) {
			estado = "Nao finalizado";
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
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
	}

	private double calculaFinancas(){
	    double caixaTotal = 0;
	    for (Aposta aposta: conjuntoApostas){
	        caixaTotal += aposta.getQtnAposta();
        }

        return caixaTotal;
    }


/*	public static void main(String[] args) {
		Cenario c = new Cenario("O ceu vai chover");
		Aposta a = new Aposta("a",100, "VAI ACONTECER");
		Aposta b = new Aposta("b",50, "N VAI ACONTECER");
		c.adicionarAposta(a);
		c.adicionarAposta(b);
		c.adicionarAposta(b);
		c.adicionarAposta(b);
		c.finalizarCenario(true);
		System.out.println(c.valorRecolhido() / 100);
	}*/
}
