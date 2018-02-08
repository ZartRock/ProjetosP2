package sistema.seguros;

public class SeguroValor extends Seguro{
	
	private int valor; 
	
	public SeguroValor(int valor) {
		super();
		
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor não pode ser negativa ou nula");
		}
		
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	
	@Override
	public String toString(){
	
		return String.format("R$ %d", this.valor);
	}
}
