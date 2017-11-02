package lab_02;

import java.util.ArrayList;

public class teste {
	public static void main(String[] args) {
		ArrayList<String> palavra = new ArrayList<String>();
		
		palavra.add("Yugioh");
		palavra.add("Pegasus");
		palavra.add("Bastion");
		palavra.add("Jaden");
		
		
		System.out.println(palavra.indexOf("Jaden"));
	}
}
