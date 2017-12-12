import org.junit.Before;
import org.junit.Test;

/**
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
    public void toString(){
        Aposta aposta = new Aposta("",1,true);

    }

}
