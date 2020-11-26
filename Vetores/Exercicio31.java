package Vetores;

import java.util.Scanner;

public class Exercicio31 {

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
		
		// CONSTRUÇÃO DO VETOR UNIÃO:
		int contador = 0;
        for (int i = 0; i < vetor1.length; i++){
            for (int j = 0; j < vetor2.length; j++){
                if (vetor1[i] == vetor2[j]){
                    contador++;
                }
            }
        }
        
        int tamanho = vetor1.length + vetor2.length - contador;
        int[] uniao = new int[tamanho];
        
        // Vetor união recebe os iguais:
        int h = 0;
        for (int i = h; i < vetor1.length; i++){
            for (int j = 0; j < vetor2.length; j++){
                if (vetor1[i] == vetor2[j]){
                    uniao[h] = vetor1[i];
                    h++;
                    break;
                }
            }
        }
        // Vetor união recebe os diferentes do vetor 1:
        for (int i = 0; i < vetor1.length; i++){
        boolean contdif1 = true;
            for (int j = 0; j < uniao.length; j++){
                if (vetor1[i] == uniao[j]){
                    contdif1 = false;
                    break;
                }
            }
            if (contdif1 == true){
                uniao[h] = vetor1[i];
                h++;
            }
        }
        
        // Vetor união recebe os diferentes do vetor 2:
        for (int i = 0; i < vetor2.length; i++){
        boolean contdif2 = true;
            for (int j = 0; j < uniao.length; j++){
                if (vetor2[i] == uniao[j]){
                    contdif2 = false;
                    break;
                }
            }
            if (contdif2 == true){
                uniao[h] = vetor2[i];
                h++;
            }
        }
        // Imprimir vetor união na ordem crescente:
        System.out.print("O vetor união é = ");
        int aux = 0;
        for (int i = 0; i < uniao.length; i++){
            for (int j = 0; j < uniao.length; j++){
                if (uniao[i] < uniao[j]){
                    aux = uniao[i];
                    uniao[i] = uniao[j];
                    uniao[j] = aux;
                }
            }
        }
        
        for (int i = 0; i < uniao.length; i++){
            System.out.print(uniao[i]+" | ");
        }
        
    }

}