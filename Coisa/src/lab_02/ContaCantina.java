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
	
	public ContaCantina(String nome) {
		this.setNomeCantina(nome);
		this.detalhesLanches = new ArrayList<String>();
	}
	
	public void cadastraLanche(int qtn, int valor) {
		this.debitoConta += valor;
		this.qtnItensConsumidos += qtn;
	}

	public void cadastraLanche(int qtn, int valor, String detalhe) {
		this.debitoConta += valor;
		this.qtnItensConsumidos += qtn;
		this.detalhesLanches.add(detalhe);
	}

	public void pagaConta(int valorDebitado) {
		this.debitoConta -= valorDebitado;
		
	}
	
	@Override
	public String toString(){
		int debito = (int) this.debitoConta;
		return (this.getNomeCantina() + " " + qtnItensConsumidos+ " " + debito);
	}
	
	public String listarDetalhes(){
		String saida = "";
		for (int i = detalhesLanches.size() - 1; i > detalhesLanches.size() - 6; i--) {
			saida += detalhesLanches.get(i);
		}
		return saida;
	}


	public String getNomeCantina() {
		return nomeCantina;
	}

	public void setNomeCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}
	
	@Override
	public boolean equals(Object obj){
		ContaCantina outro = (ContaCantina) obj;
		return this.nomeCantina.equals(outro.getNomeCantina());
	}

}

