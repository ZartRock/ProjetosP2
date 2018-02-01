package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.entidades.Aposta;

/**
 * Classe responsável por fazer os testes de "Aposta";
 * 
 * @author Áxel Medeiros
 */
public class ApostaTest {

    static public Aposta apostaExemplo;

    /**
     * Iniciar uma objeto Aposta para ser ultilizado de exemplo para outros arquivos do sistema
     * @throws Exception
     * TODO: Porque existe essa exceção??
     */
    @Before
    public void setUp() throws Exception {
        this.apostaExemplo = new Aposta("Coisinha", 100, "VAI ACONTECER");
    }

    /**
     * Testa a inicialização com todos os parametros corretos
     */
    @Test
    public void inicializarSucesso() {
        new Aposta("Axel", 1, "N VAI ACONTECER");
    }

    /**
     * Testa a inicialização com o nome nulo.
     */
    @Test(expected=NullPointerException.class)
    public void inicializarNomeNulo() {
        new Aposta(null, 1, "VAI ACONTECER");
    }
    
    /**
     * Testa a inicializacao de uma previsao nula.
     */
    @Test(expected=NullPointerException.class)
    public void inicializacaoPrevisaoNula(){
        new Aposta("A", 0.5, null);
    }

    /**
     * Testa a inicialização com o nome inválido
     */
    @Test(expected=IllegalArgumentException.class)
    public void inicializarNomeInvalido(){
        new Aposta("", 1, "N VAI ACONTECER");
    }

    /**
     * Testa a construção com o argumento "Quantidade" sendo negativa
     */
    @Test(expected=IllegalArgumentException.class)
    public void inicializarQuantidadeNegativa(){
        new Aposta("A", -1, "N VAI ACONTECER");
    }

    /**
     * Testa o caso limite onde a quantia é 0.
     */
    @Test(expected=IllegalArgumentException.class)
    public void inicializarQuantidadeLimite(){
        new Aposta("A", 0, "VAI ACONTECER");
    }
     
    
    /**
     * Testa a inicializacao de uma previsao inválida.
     */
    @Test(expected=IllegalArgumentException.class)
    public void inicializacaoPrevisaoInvalida(){
        new Aposta("A", 10, "");
    }
    
    /**
     * Testa a inicializacao de uma previsao inválida.
     */
    @Test(expected=IllegalArgumentException.class)
    public void inicializacaoPrevisaoInvalida2(){
        new Aposta("A", 10, "     ");
    }

    /**
     * Testa uma apota com uma quantidade real.
     */
    @Test()
    public void inicializarCaixaReal(){
        new Aposta("A", 0.2, "VAI ACONTECER");
    }
    
    
    /**
     * Testa a exibição da classe está correta coparando com outra com outra Aposta com as mesma informações.
     */
    @Test
    public void toStringTestAutomatico() {
        Aposta aposta2 = new Aposta("Coisinha", 100, "VAI ACONTECER");
        assertEquals(aposta2.toString(), apostaExemplo.toString());
    }
}


