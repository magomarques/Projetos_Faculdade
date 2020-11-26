package Vetores;

import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		float[] vetorV = new float [10];
		
		// ENTRADA DE 10 NÚMEROS INTEIROS OU REAIS DO VETOR V:
		System.out.println("DIGITE 10 NÚMEROS INTEIROS OU REAIS: ");
		for (int i = 0; i < vetorV.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetorV[i] = entrada.nextFloat();
		}
		
		// CÁLCULO DA MÉDIA:
	    float soma = 0;
	    for (int i = 0; i < vetorV.length; i++){
	        soma = ((soma) + vetorV[i]);
	    }
	    float media = soma/vetorV.length;
	    
	    // CÁLCULO DA SOMA DOS QUADRADOS:
	    float somaQuad = 0;
	    for (int i = 0; i < vetorV.length; i++){
	        somaQuad = (float) (somaQuad + Math.pow((vetorV[i]-media),2));
	    }
	    
	    // CÁLCULO DO DESVIO PADRÃO:
	    float desvio = (float) (somaQuad/(vetorV.length -1));
	    float desvioPadrao = (float) Math.sqrt(desvio);
	    
	    System.out.printf("O Desvio Padrão é: %.4f", desvioPadrao);

	}

}
