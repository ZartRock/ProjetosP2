package testes;

import org.junit.Before;
import org.junit.Test;
import sistema.RegrasFinancas;

public class RegrasFinancasTest {
    static private RegrasFinancas regrasFinanceiras;
    @Before
    public void setUp(){
        this.regrasFinanceiras = new RegrasFinancas(0.01,10000);
    }

    @Test
    public void inicializacaoSucesso(){
        new RegrasFinancas(0.02,100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarCaixaNegativo(){
        new RegrasFinancas(0.1,-1);
    }

    @Test
    public void inicializarCaixaLimite(){
        new RegrasFinancas(0.1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemCasaNegativa(){
        new RegrasFinancas(-0.1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemAbusica(){
        new RegrasFinancas(2,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemAbusiva(){
        new RegrasFinancas(1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inicializarPorcentagemNula(){
        new RegrasFinancas(0,-1);
    }
}
