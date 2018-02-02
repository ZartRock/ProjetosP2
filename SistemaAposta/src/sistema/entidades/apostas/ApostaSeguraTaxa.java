package sistema.entidades.apostas;

public class ApostaSeguraTaxa extends Aposta{
	
	float taxa;
	final String TIPO = "TAXA";
	
	public ApostaSeguraTaxa(String nomeApostador, double qtnAposta, String previsaoString, float taxa) {
		super(nomeApostador, qtnAposta, previsaoString);
		this.taxa = taxa;
	}
	
	//TODO: Ṕara fazer
	public int pagarSeguro() {
		return (int) (this.taxa * super.qtnAposta);
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
	
	
	
}
