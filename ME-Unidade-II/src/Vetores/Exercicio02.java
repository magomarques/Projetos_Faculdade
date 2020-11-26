package Vetores;

import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int[] vetorV = new int [10];
		
		// ENTRADA DE 10 NÚMEROS INTEIROS:
		System.out.println("DIGITE 10 NÚMEROS INTEIROS:");
		for (int i = 0; i < vetorV.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetorV[i] = entrada.nextInt();
		}
		
		// DEFINIÇÃO DOS TAMANHOS DOS VETORES V1(IMPAR) E V2(PAR):
		int contPar = 0, contImpar = 0;
		for (int i = 0; i < vetorV.length; i++) {
			if (vetorV[i] % 2 == 0) {
				contPar++;
			} else {
				contImpar++;
			}
		}
		
		// DECLARAÇÃO DOS VETORES V1(IMPAR) E V2(PAR):
		int[] vetorV1 = new int [contImpar];
		int[] vetorV2 = new int [contPar];
		
		// CAPTURA DOS ELEMENTOS DOS VETORES V1(IMPAR) E V2(PAR):
		int indicePar = 0, indiceImpar = 0;
		for (int i = 0; i < vetorV.length; i++) {
			if (vetorV[i] % 2 == 0) {
				vetorV2[indicePar] = vetorV[i];
				indicePar++;
			} else {
				vetorV1[indiceImpar] = vetorV[i];
				indiceImpar++;
			}
		}
		
		//IMPRIMIR VETOR V1(ÍMPAR):
		System.out.print("O vetor V1 (Números Ímpares) é: ");
		if (contImpar == 0) {
			System.out.print("Não foram digitados números ímpares.");
		} else {
			for (int i = 0; i < vetorV1.length; i++) {
				System.out.print(vetorV1[i]+" | ");
			}
		}
		
		//IMPRIMIR VETOR V2(PAR):
		System.out.println(" ");
		System.out.print("O vetor V2 (Números   Pares) é: ");
		if (contPar == 0) {
			System.out.print("Não foram digitados números pares.");
		} else {
			for (int i = 0; i < vetorV2.length; i++) {
				System.out.print(vetorV2[i]+" | ");
			}
		}
		
	}

}
