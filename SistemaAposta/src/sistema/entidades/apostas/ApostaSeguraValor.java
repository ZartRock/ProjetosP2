package sistema.entidades.apostas;

public class ApostaSeguraValor extends Aposta {
	
	final String TIPO = "Valor";
	int valor;
	
	public ApostaSeguraValor(String nomeApostador, double qtnAposta, String previsaoString, int valor) {
		super(nomeApostador, qtnAposta, previsaoString);
		this.valor = valor;
	}
	
	public int pagarSeguro() {
		return this.valor;
	}
	
	
	
}
