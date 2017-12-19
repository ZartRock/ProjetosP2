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

    /**
     * Testa uma inicializa do objeto com sucesso
     */
    @Test
    public void inicializarSucesso(){
        new Cenario("Vou tomar 1L de café hoje");
    }

    /**
     * Representa a tentativa de criar um objeto Cenario com a descrição vazia.
     */
    @Test(expected = NullPointerException.class)
    public void inicializarDescricaoVazia(){
        new Cenario(null);
    }

    /**
     * Representa a tentativa da inicialização com uma descrição vazia
     */
    @Test(expected=IllegalArgumentException.class)
    public void inicializarDescricaoInvalida(){
        new Cenario("");
    }


    /**
     * Representa o resta de adicionar um aposta a um cenário especifico
     */
    @Test
    public void adicionarApostaSucesso(){
        Aposta aposta = new Aposta("Pessoa",100,"VAI ACONTECER");
        this.cenarioExemplo.adicionarAposta(aposta);
    }

    /**
     * Representa o teste da representação de saída ddo tipo Cenário.
     */
    @Test
    public void toStringComParametrosTest(){
        Cenario c1 = new Cenario("Vai chover hoje");

        adicionarNumApostas(c1,2);
        adicionarNumApostas(cenarioExemplo,2);
        assertEquals(c1.toString(1), cenarioExemplo.toString(1));

    }

    /**
     * Função que representa a alocação de um Aluno exemplo em um determinado cenário.
     * @param c representa o cenário onde vão ser adicionados as apostas.
     * @param numVezes representa o número de vezes que a aposta vai ser alocada no Cenário.
     */
    @Test
    private void adicionarNumApostas(Cenario c, int numVezes){
        Aposta aposta = new Aposta("Nome",1,"VAI ACONTECER");
        for (int i = 0; i < numVezes; i++){
            c.adicionarAposta(aposta);
        }

    }

    @Test
    private void finalizarCenarioTest(){
        this.cenarioExemplo.setResultadoCenario(true);
        assertEquals(true,this.cenarioExemplo.getEstaTerminado());
    }

}
