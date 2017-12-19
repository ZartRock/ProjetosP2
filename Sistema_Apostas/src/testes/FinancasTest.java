package testes;

import org.junit.Before;
import org.junit.Test;
import sistema.Financas;

/**
 * Classe reponsável por testar "Financas"
 */
public class FinancasTest {
    static private Financas financeiro;
    @Before
    public void setUp(){
        this.financeiro = new Financas(0.01,10000);
    }

    @Test
    public void inicializacaoSucesso(){
        new Financas(0.02,100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarCaixaNegativo(){
        new Financas(0.1,-1);
    }

    @Test
    public void inicializarCaixaLimite(){
        new Financas(0.1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemCasaNegativa(){
        new Financas(-0.1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemAbusica(){
        new Financas(2,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemAbusiva(){
        new Financas(1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemNula(){
        new Financas(0,-1);
    }
}
