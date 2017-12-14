public class Facade {
	ControleSistema controle;

	public Facade() { }

	public void iniciarSistemaFinancas(double porcetagemCasa, double caixaAtual) {
		this.controle = new ControleSistema(porcetagemCasa, caixaAtual);

	}
	
	public double getCaixa(){
		return this.controle.retornarCaixaAtual();
	}

	
	public int cadastrarCenario(String descricaoCenario){
		Boolean resultado = this.controle.cadastrarCenario(descricaoCenario);
		if (resultado) {
			return this.controle.numCenario(descricaoCenario);
			
		}	
		return -1;
		
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


	public static void main(String[] args) {
		Facade a = new Facade();
		a.iniciarSistemaFinancas(0.1, 20);
		a.cadastrarCenario("alo");
		System.out.println(a.getCaixa());
	}
	
	
}
