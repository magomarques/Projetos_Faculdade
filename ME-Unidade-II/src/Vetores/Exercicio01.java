package Vetores;

import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int[] vetorA = new int [6];
		
		// ENTRADA DE 06 NUMEROS INTEIROS DO VETOR (EX.: 1,0,5,-2,-5,7)
		System.out.println("DIGITE 06 NÚMEROS INTEIROS: ");
		for (int i = 0; i < vetorA.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetorA[i] = entrada.nextInt();
		}
		
		// SOMA DOS ELEMENTOS DE ÍNDICES 0, 1 e 5 DE VETOR A:    
        int soma = vetorA[0]+vetorA[1]+vetorA[5];
        System.out.println("A soma dos elementos vetorA[0] + vetorA[1] + vetorA[5] = "+soma);
        
        System.out.println("---------------------------------------------------------------");
        
        // ATRIBUIÇÃO DO VALOR 100 NA POSIÇÃO 4 (ÍNDICE 3):
        vetorA[3] = 100;
        
        // IMPRIMIR VETOR A MODIFICADO:
        System.out.println("O vetor A modificado é: ");
        for (int i = 0; i < 6; i++){
            System.out.println("Posição ["+(i+1)+"] = "+vetorA[i]);
        }

	}

}
