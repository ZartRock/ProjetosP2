package sistema.entidades.apostas;

import java.util.ArrayList;

/**
 * Representa uma aposta com seguro.
 * @author Áxel Medeiros
 *
 */
public class ApostaTipo extends Aposta{
	Object seguro;
	String tipo;
	// posso adicionar um enum com valor(1) E TIPOS(-1)
	
	public ApostaTipo(String nomeApostador, double qtnAposta, String previsaoString, String tipo, double valor) {
		super(nomeApostador, qtnAposta, previsaoString);
		if (tipo.equals("TAXA")) {
			this.seguro = new ApostaSeguraTaxa(valor);
			this.tipo = "TAXA";
		} else if(tipo.equals("VALOR")) {
			int valorInteiro = (int) (valor);
			this.seguro = new ApostaSeguraValor(valorInteiro);
			this.tipo = "VALOR";
		} else {
			System.out.println("fudeu");
		}
		
	}
	
	
	public void alterarValorSeguro(double valor){
		if (this.tipo.equals("TAXA")){
			int valorInteiro = (int) (valor);
			this.seguro = new ApostaSeguraValor(valorInteiro);
			this.tipo = "VALOR";
		} else {
			this.seguro = new ApostaSeguraTaxa(valor);
			this.tipo = "TAXA";
		}
	}
	
	@Override
	public String toString() {
		String previsao = super.retornaResultadoEsperadoString();
		return String.format("%s - R$%.2f - %s - ASSEGURADA (%s) - %s", super.nomeApostador,
				super.qtnAposta, previsao, this.tipo, this.seguro.toString());
	}
	
	
	
}
