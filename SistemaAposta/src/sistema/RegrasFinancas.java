package sistema;

public class RegrasFinancas {
	private double porcetagemCasa, caixaAtual;
	
	public RegrasFinancas(double porcetagemCasa, double caixaAtual){
		tratarExcecoesCronstutor(porcetagemCasa, caixaAtual);
		
		this.porcetagemCasa = porcetagemCasa;
		this.caixaAtual = caixaAtual;
	}
	
	public double getCaixaAtual(){ return this.caixaAtual; }

	public double getPorcetagemCasa(){ return this.porcetagemCasa; }

	public void adicionarValorCaixa(double valor){ this.caixaAtual += valor;}

	private void tratarExcecoesCronstutor(double porcetagemCasa, double caixaAtual){
		if (caixaAtual < 0 || porcetagemCasa <= 0 || porcetagemCasa >= 1) {
			throw new IllegalArgumentException("Valores invalidos");
		}
	}
	
	
	
	 
}
