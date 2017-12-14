package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sistema.Aposta;
import sistema.Cenario;

import static org.junit.Assert.assertEquals;

/** Classe reponsável por fazer os testes na classe "sistema.Aposta".
 * @author Áxel Medeiros
 */
public class CenarioTest {

    static private Cenario cenarioExemplo;
    @Before
    public void setUp(){
        this.cenarioExemplo = new Cenario("Vai chover hoje");
    }

    @Test
    public void inicializarSucesso(){
        new Cenario("Vou tomar 1L de café hoje");
    }

    @Test(expected = NullPointerException.class)
    public void inicializarDescricaoVazia(){
        new Cenario(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void inicializarDescricaoInvalida(){
        new Cenario("");
    }

    @Test
    public void adicionarApostaSucesso(){
        Aposta aposta = new Aposta("Pessoa",100,true);
        this.cenarioExemplo.adicionarAposta(aposta);
        //TODO posso finalizar aqui ou não implementar
    }

    @Test
    public void toStringComParametrosTest(){
        Cenario c1 = new Cenario("Vai chover hoje");

        adicionarNumApostas(c1,2);
        adicionarNumApostas(cenarioExemplo,2);

        Assert.assertEquals(c1.toString(1), cenarioExemplo.toString(1));

    }


    private void adicionarNumApostas(Cenario c, int numVezes){
        Aposta aposta = new Aposta("Nome",1,true);
        for (int i = 0; i < numVezes; i++){
            c.adicionarAposta(aposta);
        }

    }

}
