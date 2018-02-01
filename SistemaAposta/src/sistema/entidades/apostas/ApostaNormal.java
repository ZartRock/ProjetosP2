package sistema.entidades.apostas;

public class ApostaNormal extends Aposta{
	
	
	public ApostaNormal(String nomeApostador, double qtnAposta, String previsaoString) {
		super(nomeApostador, qtnAposta, previsaoString);
	}

	/**
	 * Responsável por retorna um representação da aposta em formato de texto.
	 * 
	 * @return uma váriavel String que representa a Aposta.
	 */
	
	@Override
	public String toString() {
		String resultadoEsperado = super.retornaResultadoEsperadoString();

		return String.format("%s - %f - %s", this.nomeApostador,
				this.qtnAposta, resultadoEsperado);
	}
	
}
