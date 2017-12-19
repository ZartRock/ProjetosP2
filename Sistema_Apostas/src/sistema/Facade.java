package sistema;

import easyaccept.EasyAccept;

/**
 * Classe responsável de ser a fachada por onde acesso os controladores desse sistema.
 */
public class Facade {
	ControleSistema controle;

	public static void main(String[] args) {

	    args = new String[] {"sistema.Facade",
                "teste_aceitacao/us1_test.txt", "teste_aceitacao/us2_test.txt",
                "teste_aceitacao/us3_test.txt", "teste_aceitacao/us4_test.txt"};
		EasyAccept.main(args);
	}
	public Facade() { }

	public void inicializa(int caixaAtual, double porcetagemCasa) {
		this.controle = new ControleSistema(porcetagemCasa, caixaAtual);

	}
	
	public int getCaixa(){
		return this.controle.getCaixaAtual();
	}

	
	public void cadastrarCenario(String descricaoCenario){
		this.controle.cadastrarCenario(descricaoCenario);
	}
	
	public String exibirCenario(int numCenario){
		return this.controle.exibirCenario(numCenario);
	}
	
	public String exibirCenarios(){
		return this.controle.exibirTodosCenarios();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao){
		this.controle.adicionarApostaCenario(cenario,apostador,valor,previsao);
	}

	public int valorTotalDeApostas(int numCenario){ return this.controle.retornarValorTotalApostas(numCenario); }


	public int totalDeApostas(int numCenario){ return this.controle.retornarNumApostaCenario(numCenario); }


	public String exibeApostas(int numCenario){ return this.controle.exibirApostas(numCenario); }

    public void fecharAposta(int numCenario, boolean resultadoCenario){
        this.controle.fecharAposta(numCenario,resultadoCenario);
    }

    public int getCaixaCenario(int numCenario){
	    return this.controle.getCaixaCenario(numCenario);
    }

    public int getTotalRateioCenario(int numCenario){
        return this.controle.getTotalRateioCenario(numCenario);
    }



}
