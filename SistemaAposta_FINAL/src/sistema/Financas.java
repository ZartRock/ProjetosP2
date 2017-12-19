package sistema;

/**
 * Repsenta o finanças do sistema.
 */
public class Financas {
    private double porcetagemCasa;
    private int caixaAtualCentavos;

    /**
     * Representa a construção do objeto do tipo Financas
     *
     * @param porcetagemCasa Representa a porcentagem da casa.
     * @param caixaAtual     Representa o caixa inicial a qual o sistema vai trabalhar inicialmente.
     */
    public Financas(double porcetagemCasa, int caixaAtual) {
        tratarExcecoesCronstutor(porcetagemCasa, caixaAtual);

        this.porcetagemCasa = porcetagemCasa;
        this.caixaAtualCentavos = caixaAtual;
    }

    /**
     * Retorna o valor atual do caixa em centavos.
     *
     * @return Retorna o valor atual do caixa em centavos
     */
    public int getCaixaAtualCentavos() {
        return this.caixaAtualCentavos;
    }

    /**
     * Retorna a porcentagem atual inferida da casa sobre as apostas.
     *
     * @return Retorna
     */
    public double getPorcetagemCasa() {
        return this.porcetagemCasa;
    }

    /**
     * Representa a adição de novos valores para o Caixa.
     * @param valor Representa o valor a ser adicionado no caixa.
     */
    public void adicionarValorCaixa(int valor) {
        this.caixaAtualCentavos += valor;
    }

    /**
     * Realiza a operação de Lanças as exceções do construtor.
     * @param porcetagemCasa representa a porcentagem de receita retido pela casa.
     * @param caixaAtual representa o caixa atual.
     */
    private void tratarExcecoesCronstutor(double porcetagemCasa, int caixaAtual) {
        if (caixaAtual < 0) {
            throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
        }

        if (porcetagemCasa <= 0 || porcetagemCasa >= 1) {
            throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
        }

    }


}
