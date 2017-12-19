package testes;

import org.junit.Rule;
import org.junit.Test;
import sistema.ControleSistema;

/**
 * Classe reponsável por fazer os testes de "ControleSistema".
 */
public class ControleSistemaTest {


    private static ControleSistema exemplo;

    public void setUp(){
        this.exemplo = new ControleSistema(0.01,100);
        this.exemplo.cadastrarCenario("O aluno Viktor Borgino vai pagar PLP");
    }
    @Test
    public void inicializarSucesso(){
        new ControleSistema(0.01,100);
    }

    @Test
    public void exibirCenarioTest(){
    }

    @Test
    public void algumacoistest(){
        this.exemplo.cadastrarCenario("A");
        //this.exemplo.cadastrarCenario("B");
        //this.exemplo.cadastrarCenario("C");
        //System.out.println( this.exemplo.exibirCenario(1));
    }

}
