package testes;

import org.junit.Before;
import org.junit.Test;

import sistema.entidades.Financas;

import static org.junit.Assert.assertEquals;

/**
 * Classe reponsável por testar "Financas"
 * 
 * @author Áxel Medeiros
 */
public class FinancasTest {
    private Financas financeiro;
    
    @Before
    public void setUp(){
        this.financeiro = new Financas(0.01,10);
    }
    /**
     * Realiza o teste da inicialização normal da finanças
     */
    @Test
    public void inicializacaoSucesso(){
        new Financas(0.02,100);
    }
    /**
     * Realiza o teste da inicialização com caixa negativo
     */
    @Test(expected = IllegalArgumentException.class)
    public void inicializarCaixaNegativo(){
        new Financas(0.1,-1);
    }
    /**
     * Testa a construção com um valor de caixa limite igual a 0.
     */
    @Test
    public void inicializarCaixaLimite(){
        new Financas(0.1,0);
    }
    /**
     * Testa a constução de um finança com falor de porcentagem negativa.
     */
    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemCasaNegativa(){
        new Financas(-0.1,-1);
    }
    /**
     * Testa o caso de um porcentagem abusiva, sendo considerado abusiva 100% ou maior.
     */
    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemAbusica(){
        new Financas(2,-1);
    }
    /**
     * Testa a inicialização da porcentagem abusiva limite
     */
    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemAbusivaLimite(){
        new Financas(1,-1);
    }
    /**
     * Testa a inicialização com uma porcentagem da casa zerada.
     */
    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemNula(){
        new Financas(0,-1);
    }
    /**
     * Testa adicionar um valor ao caixa.
     */
    @Test
    public void adicionarValorCaixaSuceso(){
        this.financeiro.adicionarValorCaixa(10);
        assertEquals(20,this.financeiro.getCaixaAtualCentavos());
    }
    /**
     * Testa adicionar um valor negativo ao caixa.
     */
    @Test
    public void adicionarValorNegativo(){
    	this.financeiro.adicionarValorCaixa(-5);
    	assertEquals(5,this.financeiro.getCaixaAtualCentavos());
    }
}
