package Vetores;

import java.util.Scanner;

public class Exercicio38 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		float[] vetor = new float [10];
		
		// ENTRADA DE 10 NÚMEROS DO VETOR:
		System.out.println("DIGITE 10 NÚMEROS:");
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetor[i] = entrada.nextFloat();
			float aux = 0.0f;
			for (int j = 0; j < i; j++) {
				if (vetor[j] > vetor[i]) {
					aux = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = aux;
				}
				
			}
		}	
		System.out.print("O vetor digitado é: ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.printf("%.4f | ",vetor[i]);
		}
		
	}
}