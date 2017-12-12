/**
 * 
 * @author axel
 *
 */
public class Aposta {

	private String nomeApostador;
	private double qtnAposta;
	private int previsao; //Posso mudar para String
	
	public Aposta(String nomeApostador, double qtnAposta, int previsao){
		tratarExcecoesConstrutor(nomeApostador, qtnAposta, previsao);
		
		this.nomeApostador = nomeApostador;
		this.qtnAposta = qtnAposta;
		this.previsao = previsao;
	}
	
	public double getQtnAposta(){ return this.qtnAposta; }
	
	
	@Override
	public String toString(){
		String resultadoEsperado = retornaResultadoEsperadoString();
		
		return String.format("%s - %f - %s", this.nomeApostador, this.qtnAposta, resultadoEsperado);
	}
	
	private void tratarExcecoesConstrutor(String nome, double qtn, int previsao){
		if (nome.equals(null)) {
			throw new NullPointerException("Nome nulo");
		}
		
		if (nome.equals("") || qtn <= 0 || previsao > 1 || previsao < 0) {
			throw new IllegalArgumentException("Parametros inválidos");
		}
	}
	
	private String retornaResultadoEsperadoString(){
		String resultado = "";
		switch (this.previsao) {
		case 0:
			resultado = "N VAI ACONTECER";
			break;
		case 1:
			resultado = "VAI ACONTECER";
			break;
		}
		
		return resultado;
	}
	
	
	/*
	 * TODO Creio que tenho que fazer mais duas classes 
	 * * posso usar herança
	 * 
	 */

}
