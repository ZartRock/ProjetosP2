package testes;

import org.junit.Test;
import sistema.ControleSistema;

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


}
