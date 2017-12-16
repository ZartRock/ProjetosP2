package sistema;

import easyaccept.EasyAccept;

public class Facade {
	ControleSistema controle;

	public static void main(String[] args) {
		args = new String[] {"sistema.Facade", "teste_aceitacao/us1_test.txt", "teste_aceitacao/us2_test.txt"};
		EasyAccept.main(args);
	}
	public Facade() { }

	public void inicializa(double caixaAtual, double porcetagemCasa) {
		this.controle = new ControleSistema(porcetagemCasa, caixaAtual);

	}
	
	public int getCaixa(){
		return this.controle.retornarCaixaAtual();
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

	//TODO posos alterar o tipo de previsao para Boolean, logo o main seria responsável por tratar a entrada
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao){
		this.controle.adicionarApostaCenario(cenario,apostador,valor,previsao);
	}


	public double valorTotalDeApostas(int numCenario){ return this.controle.retornarValorTotalApostas(numCenario); }


	public int totalDeApostas(int numCenario){ return this.controle.retornarNumApostaCenario(numCenario); }


	public String exibeApostas(int numCenario){ return this.controle.exibirApostas(numCenario); }




}
