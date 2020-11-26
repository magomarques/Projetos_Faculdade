package Vetores;

import java.util.Scanner;

public class Exercicio34 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int[] vetor = new int [10];
		
		// ENTRADA DE 10 NUMEROS INTEIROS DISTINTOS DO VETOR:
		System.out.println("DIGITE 10 NÚMEROS INTEIROS DISTINTOS:");
		for (int h = 0; h < vetor.length; h++) {
			System.out.println("Digite o "+(h+1)+"º número = ");
			vetor[h] = entrada.nextInt();
			for (int i = 0; i < h; i++) {
				if (vetor[h] == vetor[i]) {
					System.out.println("O número "+vetor[i]+" já foi digitado. Tente outro número.");
					h--;
					break;
					}
			}	
		}
		
		System.out.print("O vetor digitado é: ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]+" | ");
		}
		
	}
}