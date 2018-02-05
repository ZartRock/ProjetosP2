package sistema.entidades;

import sistema.entidades.apostas.Aposta;
/**
 * Classe que representa um cenário de apostas no sistema.
 * 
 * @author Áxel Medeiros
 *
 */
public class CenarioBonus extends Cenario{
	// TODO: FALTA DOCUMENTAR ESTA CLASSE
	int bonus;

	
	public CenarioBonus(String descricao, int bonus) {
		super(descricao);
		this.bonus = bonus;
	}

	@Override
	public int valorRecolhido() {
		int valorRecolhidoCentavos = this.bonus;

		for (Aposta aposta : super.conjuntoApostas) {

			if ((super.resultadoCenario == true && aposta.getPrevisao() == false)
					|| (super.resultadoCenario == false && aposta.getPrevisao() == true)) {

				valorRecolhidoCentavos += aposta.getQtnAposta();

			}

		}

		return valorRecolhidoCentavos;
	}
	
	
	@Override
	public String toString(int numeracao) {
		String estado = "";

		if (super.estaTerminado == false) {
			estado = "Nao finalizado";
		} else if (super.resultadoCenario == true) {
			estado = "Finalizado (ocorreu)";
		} else {
			estado = "Finalizado (n ocorreu)";
		}
		
		float valorReais = this.bonus / 100;
		return String.format("%d - %s - %s", numeracao, super.descricao, estado, valorReais);
	}
}
