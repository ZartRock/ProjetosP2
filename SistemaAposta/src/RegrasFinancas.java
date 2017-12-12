
public class RegrasFinancas {
	private double porcetagemCasa, caixaAtual;
	
	public RegrasFinancas(double porcetagemCasa, double caixaAtual){
		tratarExcecoesCronstutor(porcetagemCasa, caixaAtual);
		
		this.porcetagemCasa = porcetagemCasa;
		this.caixaAtual = caixaAtual;
	}
	
	public double getCaixaAtual(){ return this.caixaAtual; }
	
	private void tratarExcecoesCronstutor(double porcetagemCasa, double caixaAtual){
		if (caixaAtual < 0 || porcetagemCasa <= 0 || porcetagemCasa >= 1) {
			throw new IllegalArgumentException("Valores invalidos");
		}
	}
	
	
	
	 
}
