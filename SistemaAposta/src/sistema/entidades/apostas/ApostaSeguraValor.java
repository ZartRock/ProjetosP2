package sistema.entidades.apostas;

public class ApostaSeguraValor {
	
	int valor; 
	
	public ApostaSeguraValor(int valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor não pode ser negativa");
		}
		
		this.valor = valor;
	}
	
	public int pagarAposta(){
		return valor;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	
	@Override
	public String toString(){
		return String.format("R$%d", valor);
	}
}
