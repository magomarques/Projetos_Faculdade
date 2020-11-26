package Matrizes;

import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int[][] matriz = new int[5][4];
		
		//int tamanho = matriz.length;
		//System.out.println("Linha = "+tamanho);
		
		
		// PREENCHIMENTO DA MATRIZ ATÉ A COLUNA DE ÍNDICE 2:
		System.out.println("INFORME OS DADOS DOS ALUNOS: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length-2; j++) {
				if (j == 0) {
					System.out.println("Digite o número de matrícula do "+(i+1)+"º aluno: ");
					matriz[i][j] = entrada.nextInt();
				} else if (j == 1) {
					System.out.println("Digite a média  das  provas  do "+(i+1)+"º aluno: ");
					matriz[i][j] = entrada.nextInt();
				} else if (j == 2) {
					System.out.println("Digite a média dos trabalhos do "+(i+1)+"º aluno: ");
					matriz[i][j] = entrada.nextInt();
				}
				
			}
		}
		// CÁLCULO E IDENTIFICAÇÃO DA MAIOR NOTA FINAL:
		int maior = 0, indice = 0;
		for (int i = 0; i < matriz.length; i++) {
			matriz[i][3] = matriz[i][1] + matriz[i][2];
			if (matriz[i][3] > maior) {
				maior = matriz[i][3];
				indice = i;
			}
		}
		// IMPRIMIR MATRÍCULA DO ALUNO COM MAIOR NOTA FINAL:
		System.out.println("A matrícula do aluno com maior nota final é: "+matriz[indice][0]+" (Nota = "+maior+")");
		
		// CALCULAR E IMPRIMIR A MÉDIA DAS NOTAS FINAIS:
		int soma = 0;
		float media = 0.0f;
		for (int i = 0; i < matriz.length; i++) {
			soma = soma + matriz[i][3];
		}
		media = (float) soma/matriz.length;
		
		System.out.printf("A média das notas finais é: %.2f",media);
		
	}

}
