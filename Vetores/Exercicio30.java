package Vetores;

import java.util.Scanner;

public class Exercicio30 {

	public static void main(String[] args) {
		
Scanner entrada = new Scanner (System.in);
		
		int[] vetor1 = new int [10];
		int[] vetor2 = new int [10];
		
		// ENTRADA DE 10 NUMEROS INTERIOS DISTINTOS DO VETOR 1:
		System.out.println("DIGITE 10 NÚMEROS INTEIROS DISTINTOS PARA O VETOR 1:");
		for (int i = 0; i < vetor1.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetor1[i] = entrada.nextInt();
		}
		
		// ENTRADA DE 10 NUMEROS INTERIOS DISTINTOS DO VETOR 2:
		System.out.println("DIGITE 10 NÚMEROS INTEIROS DISTINTOS PARA O VETOR 2:");
		for (int i = 0; i < vetor2.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetor2[i] = entrada.nextInt();
		}
		
		// CONSTRUÇÃO DO VETOR INTERSEÇÃO:
		// CONTAR QUANTOS NÚMEROS IGUAIS EXISTENTES NOS VETORES 1 E 2:
        int contador = 0;
        for (int i = 0; i < vetor1.length; i++){
        	for (int j = 0; j < vetor2.length; j++){
        		if (vetor1[i] == vetor2[j]){
        			contador++;
        			break;
        		}
        	}
        }
        int[] vetorInter = new int [contador];
        
        // CAPTURA DOS NÚMEROS IGUAIS EXISTENTES NOS VETORES 1 E 2:
        contador = 0;
        for (int i = 0; i < vetor1.length; i++){
        	for (int j = 0; j < vetor2.length; j++){
        		if (vetor1[i] == vetor2[j]){
        			vetorInter[contador] = vetor1[i];
        			contador++;
        			break;
        		}
        	}
        }
        
        // IMPRIMIR VETOR INTERSEÇÃO:
        System.out.print("O vetor interseção é: ");
        for (int i = 0; i < vetorInter.length; i++){
        	System.out.print(vetorInter[i]+" | ");
        }
        
    }

}