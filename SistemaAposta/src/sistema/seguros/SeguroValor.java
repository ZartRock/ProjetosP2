package sistema.seguros;

/**
 * Representa o seguro assegurado por valor no sistema.
 * 
 * @author Áxel Medeiros;
 */
public class SeguroValor extends Seguro{
	
	private int valor; 
	
	/**
	 * Contrutor do seguro por valor.
	 * @param valor
	 * 		representa o valor a ser assegurado.
	 */
	public SeguroValor(int valor) {
		super();
		
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor não pode ser negativa ou nula");
		}
		
		this.valor = valor;
	}

	
	/**
	 * Retorna uma representação do seguro por valor.
	 */
	@Override
	public String toString(){
	
		return String.format("R$ %d", this.valor);
	}
	
	/**
	 * Retorna o valor a ser paga pelo seguro.
	 */
	@Override
	public int pagarSeguro(double qtnAposta) {
		return this.valor;
	}
}
