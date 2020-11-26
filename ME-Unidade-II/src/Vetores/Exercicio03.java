package Vetores;

import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int[] vetor = new int [10];
		
		// ENTRADA DE 10 NUMEROS INTEIROS DIFERENTES DO VETOR:
		System.out.println("DIGITE 10 NÚMEROS INTEIROS DIFERENTES:");
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetor[i] = entrada.nextInt();
			for (int j = 0; j < i; j++) {
				if (vetor[i] == vetor[j]) {
					System.out.println("O número "+vetor[i]+" já foi digitado. Tente outro número.");
					// DECREMENTO DO "i" PARA PERMANECER NO LOOPING
					i--;
					break;
					}
			}	
		}
		// IMPRIMIR VETOR FINAL DIGITADO:
		System.out.print("O vetor final digitado é: ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]+" | ");
		}
		
	}
}
