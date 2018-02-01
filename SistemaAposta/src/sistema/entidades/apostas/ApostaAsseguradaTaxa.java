package sistema.entidades.apostas;

public class ApostaAsseguradaTaxa extends Aposta{
	
	float taxa;
	final String TIPO = "TAXA";
	
	public ApostaAsseguradaTaxa(String nomeApostador, double qtnAposta, String previsaoString, float taxa) {
		super(nomeApostador, qtnAposta, previsaoString);
		this.taxa = taxa;
	}
	
	//TODO: Ṕara fazer
	public int pagarSeguro() {
		
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
	
	
	
}
