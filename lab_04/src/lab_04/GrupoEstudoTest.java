package lab_04;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrupoEstudoTest {
	
	@Test
	public void criarGrupoEstudoSucesso() {
		new GrupoEstudo("Matemática Discreta");
	}
	
	@Test(expected = NullPointerException.class)
	public void instanciarValoresNulos() {
		new GrupoEstudo(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void instanciarValoresInvalidos() {
		new GrupoEstudo("");
	}
	
	@Test
	public void toStringTestVazio(){
		GrupoEstudo g1 = fazerGrupoEstudoBasico();
		GrupoEstudo g2 = fazerGrupoEstudoBasico();
		assertEquals(g2.toString(), g1.toString());
		assertEquals(
				"Grupo: Teoria dos Grafos\n" +
				"\n" +
				"Alunos do grupo Teoria dos Grafos:"
				, g1.toString());
	}
	
	public void toStringTestComCadastros(){
		GrupoEstudo grupo1 = new GrupoEstudo("Calculo II");
		GrupoEstudo grupo2 = new GrupoEstudo("Calculo II");
		alocarParticipantes(grupo1);
		alocarParticipantes(grupo2);
		assertEquals(grupo1.toString(), grupo2.toString());
		
	}
	
	public void equalsTest(){
		GrupoEstudo exemplo1 = new GrupoEstudo("Exemplo");
		GrupoEstudo exemplo2 = new GrupoEstudo("Exemplo");
		alocarParticipantes(exemplo2);
		
		assertEquals(exemplo1, exemplo2);
	}
	
		
	
	private GrupoEstudo fazerGrupoEstudoBasico(){
		return new GrupoEstudo("Teoria dos Grafos");
	}
	
	private void alocarParticipantes(GrupoEstudo g){
		g.alocarParticipante(new Aluno("A", "1", "CC"));
		g.alocarParticipante(new Aluno("B", "2", "EE"));
	}

}
