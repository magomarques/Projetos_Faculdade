package Vetores;

import java.util.Scanner;

public class Exercicio37 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		float[] vetor = new float [11];
		
		// ENTRADA DE 11 NUMEROS REAIS DO VETOR:
		System.out.println("DIGITE 11 NÚMEROS REAIS: ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetor[i] = entrada.nextFloat();
		}
		
		float aux = 0.0f;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {
				if (vetor[i] < vetor[j]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		
		aux = 0.0f;
		for (int i = 6; i < vetor.length; i++) {
			for (int j = 6; j < vetor.length; j++) {
				if (vetor[i] > vetor[j]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		
		System.out.print("O vetor ordenado é: ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.printf("%.4f | ",vetor[i]);
		}
	}
}