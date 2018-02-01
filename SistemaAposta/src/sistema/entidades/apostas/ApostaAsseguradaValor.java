package sistema.entidades.apostas;

public class ApostaAsseguradaValor extends Aposta {
	
	final String TIPO = "Valor";
	int valor;
	
	public ApostaAsseguradaValor(String nomeApostador, double qtnAposta, String previsaoString, int valor) {
		super(nomeApostador, qtnAposta, previsaoString);
		this.valor = valor;
	}
	
	public int pagarSeguro() {
		//TODO: PARA FAZER
	}
	
	
	
}
