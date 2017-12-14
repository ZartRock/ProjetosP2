package sistema;

/**
 * 
 * @author Áxel Medeiros
 *
 */
public class Aposta {

	private String nomeApostador;
	private double qtnAposta;
	private boolean previsao; //Posso mudar para String
	
	public Aposta(String nomeApostador, double qtnAposta, boolean previsao){
		tratarExcecoesConstrutor(nomeApostador, qtnAposta, previsao);
		
		this.nomeApostador = nomeApostador;
		this.qtnAposta = qtnAposta;
		this.previsao = previsao;
	}
	
	public double getQtnAposta(){ return this.qtnAposta; }

	public boolean getPrevisao(){ return this.previsao; }
	
	@Override
	public String toString(){
		String resultadoEsperado = retornaResultadoEsperadoString();
		
		return String.format("%s - %f - %s", this.nomeApostador, this.qtnAposta, resultadoEsperado);
	}
	
	private void tratarExcecoesConstrutor(String nome, double qtn, boolean previsao){
		if (nome.equals(null)) {
			throw new NullPointerException("Nome nulo");
		}
		
		if (nome.equals("") || qtn <= 0) {
			throw new IllegalArgumentException("Parametros inválidos");
		}
	}
	
	private String retornaResultadoEsperadoString(){
		String resultado = "";
		if (this.previsao){
			resultado = "VAI ACONTECER";
		}else{
			resultado = "N VAI ACONTECER";
		}
		
		return resultado;
	}
	
	
	/*
	 * TODO Creio que tenho que fazer mais duas classes 
	 *
	 * 
	 */

}
