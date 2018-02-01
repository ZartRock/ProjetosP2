package lab_02;

import java.util.Scanner;

public class ExemploEnum {
	
	
	private static Scanner input = new Scanner(System.in);;

	public enum dias {	
		SEGUNDA,TERCA,QUARTA,QUINTA,SEXTA,SABADO,DOMINGO,OUTRO;
	}
	
	public static void main(String[] args) {
		
		
		
		while(true){
			String opcao = input.nextLine();
			dias op = dias.OUTRO;
			
			try {
				op = dias.valueOf(opcao.toUpperCase());
				
			} catch (IllegalArgumentException e) {
				System.out.println("Nome inválido ");
				 
			}
			
			
			switch (op) {
			case SEGUNDA:
				System.out.println("Hj é segunda");
				break;
			case TERCA:
				System.out.println("Terca");
				break;
			case QUARTA:
				System.out.println("Quarta");
				break;
			case QUINTA:
				System.out.println("quinta");
				break;
			case SEXTA:
				System.out.println("sexta");
				break;
			case SABADO:
				System.out.println("sabado");
				break;
			case DOMINGO:
				System.out.println("doming");
				break;
			default:
				System.out.println("Por favor, digite novamente");
				break;
			}
		}
	}

}
