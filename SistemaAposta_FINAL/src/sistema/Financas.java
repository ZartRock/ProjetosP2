package sistema;

public class Financas {
	private double porcetagemCasa;
	private int caixaAtualCentavos;
	
	public Financas(double porcetagemCasa, int caixaAtual){
		tratarExcecoesCronstutor(porcetagemCasa, caixaAtual);
		
		this.porcetagemCasa = porcetagemCasa;
		this.caixaAtualCentavos = caixaAtual;
	}
	
	public int getCaixaAtualCentavos(){ return this.caixaAtualCentavos; }

	public double getPorcetagemCasa(){ return this.porcetagemCasa; }

	public void adicionarValorCaixa(int valor){ this.caixaAtualCentavos += valor;}

	private void tratarExcecoesCronstutor(double porcetagemCasa, int caixaAtual){
		if (caixaAtual < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}

		if (porcetagemCasa <= 0 || porcetagemCasa >= 1){
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}

	}
	
	
	
	 
}
