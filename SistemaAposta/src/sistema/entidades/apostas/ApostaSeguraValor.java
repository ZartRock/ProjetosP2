package sistema.entidades.apostas;

public class ApostaSeguraValor {
	
	int valor; 
	
	public ApostaSeguraValor(int valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor não pode ser negativa ou nula");
		}
		
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}	
}
