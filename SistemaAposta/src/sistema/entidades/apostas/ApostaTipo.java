package sistema.entidades.apostas;

import java.util.ArrayList;

public class ApostaTipo extends Aposta{
	Object seguro;
	String tipo;
	
	
	public ApostaTipo(String nomeApostador, double qtnAposta, String previsaoString, String tipo, float valor) {
		super(nomeApostador, qtnAposta, previsaoString);
		if (tipo.equals("TAXA")) {
			this.seguro = new ApostaSeguraTaxa(valor);
			this.tipo = "TAXA";
		} else if(tipo.equals("VALOR")) {
			this.seguro = new ApostaSeguraValor((int) (valor));
			this.tipo = "VALOR";
		} else {
			//TODO: LANCAR UM ERRO
		}
	}
	
	
	
	
//	@Override
//	public String toString() {
//		String previsao = super.retornaResultadoEsperadoString();
//		return String.format(“%s - %f - %s - ASSEGURADA (%s) - VALOR”, super.nomeApostador, super.qtnAposta, previsao, this.tipo);
//	}
	
}
