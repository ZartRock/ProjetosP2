package sistema;

public class Financas {
	private double porcetagemCasa, caixaAtual;
	
	public Financas(double porcetagemCasa, double caixaAtual){
		tratarExcecoesCronstutor(porcetagemCasa, caixaAtual);
		
		this.porcetagemCasa = porcetagemCasa;
		this.caixaAtual = caixaAtual;
	}
	
	public double getCaixaAtual(){ return this.caixaAtual; }

	public double getPorcetagemCasa(){ return this.porcetagemCasa; }

	public void adicionarValorCaixa(double valor){ this.caixaAtual += valor;}

	private void tratarExcecoesCronstutor(double porcetagemCasa, double caixaAtual){
		if (caixaAtual < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}

		if (porcetagemCasa <= 0 || porcetagemCasa >= 1){
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}

	}
	
	
	
	 
}
