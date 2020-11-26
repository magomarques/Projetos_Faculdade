package Vetores;

import java.util.Scanner;

public class Exercicio28 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int[] vetorV = new int [10];
		
		// ENTRADA DE 10 NUMEROS INTERIOS:
		System.out.println("DIGITE 10 NÚMEROS INTEIROS");
		for (int i = 0; i < vetorV.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetorV[i] = entrada.nextInt();
		}
		
		// DEFINIÇÃO DO TAMANHO DOS VETORES PAR E IMPAR:
		int contPar = 0, contImpar = 0;
		for (int i = 0; i < vetorV.length; i++) {
			if (vetorV[i] % 2 == 0) {
				contPar++;
			} else {
				contImpar++;
			}
		}
		
		// CRIAR VETORES PAR E IMPAR:
		int[] vetorPar = new int [contPar];
		int[] vetorImpar = new int [contImpar];
		
		// CAPTURA DOS ELEMENTOS DOS VETORES PAR E IMPAR:
		int indicePar = 0, indiceImpar = 0;
		for (int i = 0; i < vetorV.length; i++) {
			if (vetorV[i] % 2 == 0) {
				vetorPar[indicePar] = vetorV[i];
				indicePar++;
			} else {
				vetorImpar[indiceImpar] = vetorV[i];
				indiceImpar++;
			}
		}
		
		//IMPRIMIR VETOR ÍMPAR:
		System.out.print("O vetor 1 (Números Ímpares) é: ");
		for (int i = 0; i < vetorImpar.length; i++) {
			System.out.print(vetorImpar[i]+" | ");
		}
		
		//IMPRIMIR VETOR PAR:
		System.out.println(" ");
		System.out.print("O vetor 2 (Números   Pares) é: ");
		for (int i = 0; i < vetorPar.length; i++) {
			System.out.print(vetorPar[i]+" | ");
		}
		
	}

}
