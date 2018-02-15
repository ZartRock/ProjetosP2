package sistema.seguros;
/**
 * Reprenta o seguro feito por Taxa
 * 
 * @author Áxel Medeiros.
 *
 */
public class SeguroTaxa extends Seguro{
	private double taxa;
	
	
	/**
	 * Construtor do objeto
	 * @param taxa
	 * 		representa a taxa a ser assegurada.
	 */
	public SeguroTaxa(double taxa) {
		super();
		if (taxa <= 0) {
			throw new IllegalArgumentException("Taxa não pode ser negativa ou nula");
		}
		this.taxa = taxa;
	}
	
	/**
	 * Retorna o valor a ser pago pelo seguro.
	 */
	@Override
	public int pagarSeguro(double qtnAposta) {
		return (int) Math.floor(qtnAposta * taxa);
	}
	
	/**
	 * Retorna uma representação do seguro feito por taxa.
	 */
	@Override
	public String toString(){
	
		return String.format("%.0f%%", this.taxa * 100);
	}


	
}
