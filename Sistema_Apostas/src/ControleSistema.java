import java.util.ArrayList;

public class ControleSistema {

	private ArrayList<Cenario> cenarios;
	private RegrasFinancas financeiro;
	
	public ControleSistema(double porcetagemCasa, double caixaAtual){
		this.cenarios = new ArrayList<Cenario>();
		this.financeiro = new RegrasFinancas(porcetagemCasa, caixaAtual);
	}
	
	public double retornarCaixaAtual(){	return this.financeiro.getCaixaAtual(); }
	
	public boolean cadastrarCenario(String descricaoCenario){
		this.cenarios.add(new Cenario(descricaoCenario));
		return true;
	}
	
	public int numCenario(String descricaoCenario){
		for (int i = 0; i < this.cenarios.size(); i++) {
			if (this.cenarios.get(i).getDescricao().equals(descricaoCenario)) {
				return i;
			}
		}
		
		throw new IndexOutOfBoundsException("Numerador de cenario não existente");
	}
	
	public boolean adicionarApostaCenario(int numCenario, String nomeApostador, double qtnAposta, int previsao){
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
	
}
