package Matrizes;

import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		float[][] matriz = new float[3][6];
		
		// PREENCHIMENTO DA MATRIZ:
		System.out.println("INFORME OS ELEMENTOS DA MATRIZ: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length+3; j++) {
					System.out.println("Digite o elemento["+(i)+"]["+(j)+"] da matriz: ");
					matriz[i][j] = entrada.nextFloat();
			}
		}
		// IMPRIMIR A SOMA DE TODOS OS ELEMENTOS DAS COLUNAS IMPARES (1ª, 3ª E 5ª):
		// OBS.: 1ª COLUNA (ÍNDICE 0) / 3ª COLUNA (ÍNDICE 2) / 5ª COLUNA (ÍNDICE 4):
		System.out.println("------------------------------------------------------------");
		float soma = 0.0f;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length+3; j++) {
				if (j % 2 == 0) {
					soma = soma + matriz[i][j];
				}
			}
		}
		System.out.printf("A soma de todos os elementos das colunas ímpares é: %.2f", soma);
		System.out.println();
		
		// IMPRIMIR A MÉDIA DOS ELEMENTOS DA 2ª (ÍNDICE 1) E 4ª (ÍNDICE 3) COLUNAS:
		System.out.println("------------------------------------------------------------");
		int contador = 0;
		float media = 0.0f;
		soma = 0.0f;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length+3; j++) {
				if (j == 1 || j == 3) {
					soma = soma + matriz[i][j];
					contador++;
				}
			}
		}
		media = soma/contador;
		System.out.printf("A média da soma dos elementos da 2ª e 4ª colunas é: %.2f", media);
		System.out.println();
		
		// IMPRIMIR SUBSTITUINDO OS ELEMENTOS DA 6ª (ÍNDICE 5) COLUNA PELA SOMA DOS ELEMENTOS DA 1ª (ÍNDICE 0) E 2ª (ÍNDICE 1) COLUNAS:
		System.out.println("------------------------------------------------------------");
		for (int i = 0; i < matriz.length; i++) {
				matriz[i][5] = matriz[i][0] + matriz[i][1];
			}
		System.out.println("A matriz modificada (6ª COLUNA = 1ª + 2ª COLUNA) é: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length+3; j++) {
				System.out.printf("%.2f | ", matriz[i][j]);
			}
		System.out.println();
		}
	}

}
