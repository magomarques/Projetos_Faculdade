package Vetores;

import java.util.Scanner;

public class Exercicio33 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int[] vetor = new int [15];
		
		// ENTRADA DE 15 NUMEROS INTEIROS DO VETOR:
		System.out.println("DIGITE 15 NÚMEROS INTEIROS DISTINTOS:");
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetor[i] = entrada.nextInt();
		}
		
		// CONSTRUÇÃO DO VETOR SEM ZEROS:
		int tamanho = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != 0) {
				tamanho++;
			}
		}
		
		int[] vetorCompacto = new int[tamanho];
		
		// ELIMINAR OS ZEROS DO VETOR INICIAL:
		int contador = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != 0) {
				vetorCompacto[contador] = vetor[i];
				contador++;
			}
		
		}
		
		// IMPRIMIR O VETOR COMPACTADO:
		System.out.print("O vetor compactado (sem zeros) é = ");
		for (int i = 0; i < vetorCompacto.length; i++) {
			System.out.print(vetorCompacto[i]+" | ");
		}
	}

}