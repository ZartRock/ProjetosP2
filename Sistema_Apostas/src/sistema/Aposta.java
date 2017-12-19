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
	
	public Aposta(String nomeApostador, double qtnAposta, String previsaoString){
		tratarExcecoesConstrutor(nomeApostador, qtnAposta, previsaoString);

		this.nomeApostador = nomeApostador;
		this.qtnAposta = qtnAposta;
		this.previsao = retornarValorPrevisao(previsaoString);
	}
	
	public double getQtnAposta(){ return this.qtnAposta; }

	public boolean getPrevisao(){ return this.previsao; }
	
	@Override
	public String toString(){
		String resultadoEsperado = retornaResultadoEsperadoString();
		
		return String.format("%s - %f - %s", this.nomeApostador, this.qtnAposta, resultadoEsperado);
	}
	
	private void tratarExcecoesConstrutor(String nome, double qtn, String previsaoString){
		if (nome.equals(null)) {
			throw new NullPointerException("Nome nulo");
		}
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		} else if (qtn <= 0){
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}

		if (previsaoString.trim().equals("") || previsaoString.equals(null)){
		    throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
        }


	}

	private boolean retornarValorPrevisao(String previsaoString){
        if(previsaoString.equals("VAI ACONTECER")){
            return true;
        }else if(previsaoString.equals("N VAI ACONTECER")){
            return false;
        } else throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
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
