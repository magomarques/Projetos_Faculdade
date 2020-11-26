package Vetores;

import java.util.Scanner;

public class Exercicio04 {

	public static void main(String[] args) {
		
		//DECLARAR UM VETOR A NESTA ORDEM A1 < A2 <...< A6 >...> A10 > A11:
		//Exemplo = {1,3,5,7,9,11,10,8,6,4,2}
		float[] vetorA = new float[11];
		
		Scanner entrada = new Scanner (System.in);
		
		// PREENCHIMENTO DO VETOR A:
		for (int i = 0; i < vetorA.length; i++) {
			System.out.printf("Digite o "+(i+1)+"º elemento do vetor A:");
			vetorA[i] = entrada.nextFloat();
				if (i > 0 && i <= 5) {
					if (vetorA[i] <= vetorA[i-1]) {
						System.out.println("------------------------------------");
						System.out.printf("DIGITE UM VALOR MAIOR QUE %.2f",vetorA[i-1]);
						System.out.println();
						System.out.println("------------------------------------");
						i--;
					}
				}
				
				if (i > 5) {
					if (vetorA[i] >= vetorA[i-1]) {
						System.out.println("------------------------------------");
						System.out.printf("DIGITE UM VALOR MENOR QUE %.2f",vetorA[i-1]);
						System.out.println();
						System.out.println("------------------------------------");
						i--;
					}
				}
				
		}
		
		// IMPRIMIR VETOR A ORIGINAL:
		System.out.println("------------------------------------");
		System.out.println("O vetor A original é : ");
		for (int i = 0; i < vetorA.length; i++) {
			System.out.printf("%.2f | ",vetorA[i]);
		}
		System.out.println();
		
		// ORDENAR O VETOR A (ORDEM CRESCENTE):
		float aux = 0;
		for (int x = 0; x < vetorA.length; x++) {
			for (int y = 0; y < vetorA.length; y++) {
				if (vetorA[x] < vetorA[y]) {
					aux = vetorA[x];
					vetorA[x] = vetorA[y];
					vetorA[y] = aux;
				}
			}
		}
		// IMPRIMIR VETOR A EM ORDEM CRESCENTE:
		System.out.println("------------------------------------");
		System.out.println("O vetor A ordenado (ordem crescente) é : ");
		for (int i = 0; i < vetorA.length; i++) {
			System.out.printf("%.2f | ",vetorA[i]);
		}
	}
}