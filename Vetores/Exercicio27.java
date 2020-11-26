package Vetores;

import java.util.Scanner;

public class Exercicio27 {

	public static void main(String[] args) {
		
	Scanner entrada = new Scanner (System.in);
	
	int[] vetor = new int[10];
	
	// ENTRADA DE 10 NÚMEROS INTEIROS DIFERENTES DE ZERO:
	System.out.println("DIGITE 10 NÚMEROS DIFERENTES DE ZERO");
	for (int i = 0; i < vetor.length; i++) {
		System.out.println("Digite o "+(i+1)+"º número = ");
		vetor[i] = entrada.nextInt();		
	}
	
	// CAPTURA DO MAIOR NÚMERO PARA LIMITE DO FOR "j":
	int maior = 0;
	for (int i = 0; i < vetor.length; i++) {
		if (vetor[i] > maior) {
			maior = vetor[i];
		}
	}
	
	// CAPTURA DO NÚMEROS PRIMOS:
	for (int i = 0; i < vetor.length; i++) {
		int divisor = 0;
		for (int j = 1; j <= maior; j++) {
			if (vetor[i] % j == 0) {
				divisor++;
				if (divisor > 2) {
					break;
				}
			}
		}
		// IMPRIMIR NÚMEROS PRIMOS E SUA POSIÇÃO:
		if (divisor == 2) {
		System.out.println("O número "+vetor[i]+"\té PRIMO e está na "+(i+1)+"ª\tposição.");
		}
	}	
	
	}

}