package Vetores;

import java.util.Scanner;

public class Exercicio35 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int a = 0, b = 0;
		
		// ENTRADA DE 2 NUMEROS INTEIROS DISTINTOS MENOR QUE 10.000:
		do {
		System.out.println("DIGITE DOIS NÚMEROS INTEIROS MENORES QUE 10.000:");
		System.out.println("Digite o 1º número = ");
		a = entrada.nextInt();
		System.out.println("Digite o 2º número = ");
		b = entrada.nextInt();
		} while (a > 9999 || b > 9999);
		
		// CONSTRUÇÃO DOS VETORES:
		calculo(a);
		calculo(b);
		
		}
	
	// MÉTODO AUXILIAR PARA CONTRUÇÃO DOS VETORES:
	public static void calculo (int num) {
		
		int milhar = 0, centena = 0, dezena = 0, unidade = 0;
		
		while (num > 1000) {
			num = num - 1000;
			milhar++;
		}
		while (num > 100) {
			num = num - 100;
			centena++;
		}
		while (num > 10) {
			num = num - 10;
			dezena++;
		}
		
		unidade = num;
		
		int[] vetor = new int [4];
		
		vetor[0] = unidade;
		vetor[1] = dezena;
		vetor[2] = centena;
		vetor[3] = milhar;
		
		// IMPRIMIR VETOR A E B:
		System.out.print("O vetor de inteiros invertido do número é: ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]+" | ");
		}
		System.out.println(" ");
	}

}