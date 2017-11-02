package lab_02;

import java.util.Scanner;

/**
* Classe principal do projeto, onde seu objetivo é inicar a execução do
* projeto Controle Institucional da Situação Acadêmica (COISA).
* 
* @author Áxel Medeiros
*/

public class Coisa {

	private static Scanner input;


	public static void main(String[] args) {
    	input = new Scanner(System.in);
    	
    	int x = 1;
        do {
        	String operacao = input.nextLine();
        	switch (operacao) {
			case "CRIAR ALUNO":
				System.out.println("Digite o nome Aluno:");
				String nome = input.nextLine();
				Aluno fulano = new Aluno(nome);
				System.out.println(fulano);
				break;
			
			case "CANTINA":
				
				break;
			default:
				imprimirMenu();
				break;
			}
			
		} while (x == 1);
    	/*  
            ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");
            contaLCC2.consomeEspaco(1999);
            System.out.println(contaLCC2.atingiuCota());
            contaLCC2.consomeEspaco(2);
            System.out.println(contaLCC2.atingiuCota());
            contaLCC2.liberaEspaco(1);
            System.out.println(contaLCC2.atingiuCota());
            contaLCC2.liberaEspaco(1);
            System.out.println(contaLCC2.atingiuCota());
            System.out.println(contaLCC2.toString());
 
    
            Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
            prog2.cadastraHoras(4);
            prog2.cadastraNota(1, 5.0);
            prog2.cadastraNota(2, 6.0);
            prog2.cadastraNota(3, 7.0);
            System.out.println(prog2.aprovado());
            prog2.cadastraNota(4, 10.0);
            System.out.println(prog2.aprovado());
            System.out.println(prog2.toString());

           
            ContaCantina mulherDoBolo = new ContaCantina("Mulher do Bolo");            
            mulherDoBolo.cadastraLanche(2, 500, "Gostei da esfirra");
            mulherDoBolo.cadastraLanche(1, 500, "O bolo não foi taum bom...");
            mulherDoBolo.pagaConta(200);
            System.out.println(mulherDoBolo.toString());

           
            Saude saude = new Saude();
            System.out.println(saude.geral());
            saude.defineSaudeMental("boa");
            saude.defineSaudeFisica("boa");
            System.out.println(saude.geral());
            saude.defineSaudeMental("fraca");
            saude.defineSaudeFisica("fraca");
            System.out.println(saude.geral());
            saude.defineSaudeMental("boa");
            saude.defineSaudeFisica("fraca");
            System.out.println(saude.geral());
         */
    }
	
	
	private static void imprimirMenu(){
		System.out.println("MENU");
		System.out.println("CRIAR ALUNO");
		System.out.println("Exemplo");
	}

   

}