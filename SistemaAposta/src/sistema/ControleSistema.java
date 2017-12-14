package sistema;

import java.util.ArrayList;

public class ControleSistema {

	private ArrayList<Cenario> cenarios;
	private RegrasFinancas financeiro;
	
	public ControleSistema(double porcetagemCasa, double caixaAtual){
		this.cenarios = new ArrayList<Cenario>();
		this.financeiro = new RegrasFinancas(porcetagemCasa, caixaAtual);
	}
	
	public double retornarCaixaAtual(){	return this.financeiro.getCaixaAtual(); }
	
	public void cadastrarCenario(String descricaoCenario){
		this.cenarios.add(new Cenario(descricaoCenario));
	}
	
	public int numCenario(String descricaoCenario){
		for (int i = 0; i < this.cenarios.size(); i++) {
			if (this.cenarios.get(i).getDescricao().equals(descricaoCenario)) {
				return i;
			}
		}
		
		throw new IndexOutOfBoundsException("Numerador de cenario não existente");
	}
	
	public boolean adicionarApostaCenario(int numCenario, String nomeApostador, double qtnAposta, String previsaoString){
		Boolean previsao = (previsaoString.equals("vai")? true : false); // posso remover mais tarde


	    if (numCenario < 0 || numCenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Cenário inexiste");
		}
		
		Aposta aposta = new Aposta(nomeApostador, qtnAposta, previsao);
		this.cenarios.get(numCenario).adicionarAposta(aposta);
		return true;
	}
	
	public String exibirCenario(int numCenario){
		return this.cenarios.get(numCenario).toString();
	}
	
	public String exibirTodosCenarios(){
		String saida = "";
		for (int i = 0; i < this.cenarios.size(); i++) {
			saida += this.cenarios.get(i).toString();
		}
		
		return saida;
	}

	public int retornarNumApostaCenario(int numCenario){
        return this.cenarios.get(numCenario).getNumApostas();
    }

    public String exibirApostas(int numCenairo){
		return this.cenarios.get(numCenairo).exibeApostas();
    }

    public double retornarValorTotalApostas(int numCenario){
	    return this.cenarios.get(numCenario).getValorTotalApostas();
    }

    public int getCaixaCenario(int numCenario){
	    double totalApostas = this.cenarios.get(numCenario).getValorTotalApostas();

	    return (int)(totalApostas * this.financeiro.getPorcetagemCasa());
	}


    public void fecharAposta(int numCenario, boolean ocorreu){
		Cenario cenario = this.cenarios.get(numCenario);
		cenario.setResultadoCenario(ocorreu);
		double valorParaCaixa = cenario.valorRecolhido() * this.financeiro.getPorcetagemCasa();

		this.financeiro.adicionarValorCaixa(valorParaCaixa);
    }


    public int getTotalRateioCenario(int numCenario){
		Cenario cenario = this.cenarios.get(numCenario);
		return (int) Math.floor((cenario.valorRecolhido() - cenario.valorRecolhido() * financeiro.getPorcetagemCasa()));
	}


}
