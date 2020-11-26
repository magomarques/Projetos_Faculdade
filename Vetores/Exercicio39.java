package Vetores;

import java.util.Scanner;

public class Exercicio39 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int n = 0;
		
		// ENTRADA DE UM NÚMERO INTEIRO:
		System.out.println("Digite um número interio: ");
		n = entrada.nextInt();
		
		int[] vetor = new int[n+1];
		
		System.out.println("O triângulo de Pascal para "+n+" é: ");
		vetor[0] = 1;
		for (int i = 0; i <= n; i++) {
			int aux1 = 0, aux2 = 0;
			for (int j = 0; j <= i; j++) {
			aux2 = aux1 + vetor[j];
			aux1 = vetor[j];
			vetor[j] = aux2;
			System.out.print(vetor[j]+" ");		
		}	
			System.out.println(" ");
		}
	}
}