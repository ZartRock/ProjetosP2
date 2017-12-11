public class Facade {
	ControleSistema controle;

	public Facade() { }

	public void iniciarSistemaFinancas(double porcetagemCasa, double caixaAtual) {
		this.controle = new ControleSistema(porcetagemCasa, caixaAtual);

	}
	
	public double getCaixa(){
		return this.controle.retornarCaixaAtual();
	}
	
	public boolean cadatrarAposta(int numCenario, String nomeApostador, double qtnAposta, int previsao){
		return this.controle.adicionarApostaCenario(numCenario, nomeApostador, qtnAposta, previsao);

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
	
	

	public static void main(String[] args) {
		Facade a = new Facade();
		a.iniciarSistemaFinancas(0.1, 20);
		a.cadastrarCenario("alo");
		System.out.println(a.getCaixa());
	}
	
	
}
