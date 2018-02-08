package sistema.apostas;

import sistema.seguros.SeguroTaxa;
import sistema.seguros.SeguroValor;

/**
 * Representa uma aposta com seguro.
 * @author Áxel Medeiros
 *
 */
public class ApostaSegura extends Aposta{
	private Object seguro;
	private String tipo;
	
	public ApostaSegura(String nomeApostador, double qtnAposta, String previsaoString, String tipo, double valor) {
		super(nomeApostador, qtnAposta, previsaoString);
		
		
		if (tipo.equals("TAXA")) {
			this.seguro = new SeguroTaxa(valor);
			this.tipo = "TAXA";
		} else if(tipo.equals("VALOR")) {
			int valorInteiro = (int) (valor);
			this.seguro = new SeguroValor(valorInteiro);
			this.tipo = "VALOR";
		} else {
			//TODO: RETORNA ALGUM ERRO
		}
		
	}
	
	public void alterarParaValor(int valor){
		this.seguro = new SeguroValor(valor);
		this.tipo = "VALOR";
	}

	public void alterarParaTaxa(double taxa) {
		this.seguro = new SeguroTaxa(taxa);
		this.tipo = "TAXA";
	}
	
//	public int pagarAposta() {
//		
//	}

	public String getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		String previsao = super.retornaResultadoEsperadoString();
		return String.format("%s - R$%.2f - %s - ASSEGURADA (%s) - %s", super.nomeApostador,
				super.qtnAposta, previsao, this.tipo, this.seguro.toString());
	}
}
