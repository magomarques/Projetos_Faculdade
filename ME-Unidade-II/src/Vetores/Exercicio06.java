package Vetores;

import java.util.Scanner;

public class Exercicio06 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		float[] vetorX = new float [5];
		float[] vetorY = new float [5];
		
		// ENTRADA DE 5 NÚMEROS REAIS DO VETOR X:
		System.out.println("DIGITE 5 NÚMEROS REAIS PARA O VETOR X: ");
		for (int i = 0; i < vetorX.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetorX[i] = entrada.nextFloat();
		}
		
		// ENTRADA DE 5 NÚMEROS REAIS DO VETOR Y:
		System.out.println("DIGITE 5 NÚMEROS REAIS PARA O VETOR Y: ");
		for (int i = 0; i < vetorY.length; i++) {
			System.out.println("Digite o "+(i+1)+"º número = ");
			vetorY[i] = entrada.nextFloat();
		}
		
		// IMPRIMIR VETOR X E Y:
	    System.out.print("O vetor X é: ");
	    imprimir(vetorX);
	    System.out.print("O vetor Y é: ");
	    imprimir(vetorY);
	        
	    float produto = 0;
	    for (int i = 0; i < vetorX.length; i++){
	        produto = produto + vetorX[i]*vetorY[i];
	    }
	    
	    System.out.print("O produto escalar é: " +produto);
	    
	    }

	    public static void imprimir(float[] vetor){
	        for (int i = 0; i < vetor.length; i++){
	            System.out.print(vetor[i]+" | ");
	            }
	            System.out.println(" ");

	}

}
