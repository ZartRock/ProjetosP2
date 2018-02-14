package sistema.seguros;

/**
 * Classe abstrata que representa o seguro das apostas.l
 * 
 * @author Áxel Medeiros
 */
public abstract class Seguro {
	
	/**
	 * Contrói a classe abstrata
	 */
	public Seguro() {}	
	
	/**
	 * Realiza o pagamento dos seguros
	 * @param qtnAposta
	 * 		representa a quantidade da aposta
	 * 
	 * @return	o novo valor a ser assegurado.
	 */
	public abstract int pagarSeguro(double qtnAposta);
}