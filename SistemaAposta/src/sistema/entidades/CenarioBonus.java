package sistema.entidades;

/**
 * Classe que representa um cenário de apostas no sistema.
 * 
 * @author Áxel Medeiros
 *
 */
public class CenarioBonus extends Cenario{
	// TODO: FALTA DOCUMENTAR ESTA CLASSE
	int bonus;

	/**
	 * Construtor da classe cenário bônus.
	 * @param descricao
	 * 		Refere-se a descrição geral ou contexto básico da aposta.
	 * @param bonusCentavos
	 * 		Refere-se ao valor em centavos dado de bônus na aposta.
	 */
	public CenarioBonus(String descricao, int bonusCentavos) {
		super(descricao);
		if (bonusCentavos <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido"); }
		
		this.bonus = bonusCentavos;
	}
	
	/**
	 * Retorna o rateio total de um cenário.
	 */
	@Override
	public int getRateio() {
		return this.bonus + super.valorRecolhido();
	}
	
	/**
	 * Retorna uma representação do cenário bônus em uma única String
	 */
	@Override
	public String toString(int numeracao) {
		String estado = estadoCenario();
		float valorReais = this.bonus / 100;
		return String.format("%d - %s - %s - R$ %.2f", numeracao, super.descricao, estado, valorReais);
	}
	
	/**
	 * Retorna um string contendo o estado atual do cenário.
	 * @return
	 * 		um String contendo o estado atual do cenário.
	 */
	private String estadoCenario() {
		if (this.estaTerminado == false) {
			return "Nao finalizado";
		} else if (this.resultadoCenario == true) {
			return "Finalizado (ocorreu)";
		} else {
			return "Finalizado (n ocorreu)";
		}
	}
}
