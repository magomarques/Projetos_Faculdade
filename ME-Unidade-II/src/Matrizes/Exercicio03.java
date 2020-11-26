package Matrizes;

import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		float[][] matriz1 = new float[2][2];
		float[][] matriz2 = new float[2][2];
		float[][] matrizSoma = new float[2][2];
		float[][] matrizSubt = new float[2][2];
		float constante1 = 0.0f, constante2 = 0.0f;
		boolean validacaoSoma = false, validacaoSubt = false, validacaoConst = false;
		boolean saida = false;
		
				
		// PREENCHIMENTO DAS MATRIZ 1:
		System.out.println("INFORME OS ELEMENTOS DA MATRIZ 1: ");
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1.length; j++) {
					System.out.println("Digite o elemento["+(i)+"]["+(j)+"] da matriz 1: ");
					matriz1[i][j] = entrada.nextFloat();
			}
		}
		System.out.println("-------------------------------------------");
		
		// PREENCHIMENTO DAS MATRIZ 2:
		System.out.println("INFORME OS ELEMENTOS DA MATRIZ 2: ");
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2.length; j++) {
					System.out.println("Digite o elemento["+(i)+"]["+(j)+"] da matriz 2: ");
					matriz2[i][j] = entrada.nextFloat();
			}
		}
		System.out.println("-------------------------------------------");
		
		String opcao = " ";
				
		do {
			// CONSTRUÇÃO DO MENU DE OPÇÕES:
			System.out.println("ESCOLHA UMA DAS OPÇÕES: ");
			System.out.println("a) Somar as duas matrizes;");
			System.out.println("b) Substrair a 1ª matriz da 2ª matriz;");
			System.out.println("c) Adicionar uma constante as duas matrizes;");
			System.out.println("d) Imprimir as matrizes;");
			System.out.println("e) SAIR.");
			
			System.out.print("Digite a sua opção: ");
			opcao = entrada.next();
			System.out.println("-------------------------------------------");
			
			// EXECUÇÃO DAS OPÇÕES:
			switch (opcao){
			
			// a) SOMAR AS DUAS MATRIZES:
	        case "a":
	        	validacaoSoma = true;
	        	for (int i = 0; i < matriz1.length; i++) {
	        		for (int j = 0; j < matriz2.length; j++) {
	        			matrizSoma[i][j] = matriz1[i][j] + matriz2[i][j];
	        		}
	        	}
	        	break;
	        
	        // SUBTRAIR A 1ª MATRIZ DA 2ª MATRIZ:
	        case "b":
	        	validacaoSubt = true;
	        	for (int i = 0; i < matriz2.length; i++) {
	        		for (int j = 0; j < matriz1.length; j++) {
	        			matrizSubt[i][j] = matriz2[i][j] - matriz1[i][j];
	        		}
	        	} 
	            break;
	        
	        // ADICIONAR UMA CONSTANTE AS DUAS MATRIZES:
	        case "c":
	        	validacaoConst = true;
	            System.out.print("DIGITE UMA CONSTANTE PARA A MATRIZ 1: ");
	        	constante1 = entrada.nextFloat();
	        	System.out.println("-------------------------------------------");
	        	
	        	System.out.print("DIGITE UMA CONSTANTE PARA A MATRIZ 2: ");
	        	constante2 = entrada.nextFloat();
	        	System.out.println("-------------------------------------------");
	        	
	        	for (int i = 0; i < matriz1.length; i++) {
	        		for (int j = 0; j < matriz2.length; j++) {
	        			matriz1[i][j] = constante1 + matriz1[i][j];
	        			matriz2[i][j] = constante2 + matriz2[i][j];
	        		}
	        	}	        	
	        	break;
	        
	        case "d":
	            // IMPRIMIR AS MATRIZES:
	        	System.out.println("A matriz 1 é: ");
	        	for (int i = 0; i < matriz1.length; i++) {
	        		for (int j = 0; j < matriz1.length; j++) {
	        			System.out.printf("%.2f\t", matriz1[i][j]);
	        		}
	        	System.out.println();
	        	}
	        	System.out.println("-------------------------------------------");
	        	
	        	System.out.println("A matriz 2 é: ");
	        	for (int i = 0; i < matriz2.length; i++) {
	        		for (int j = 0; j < matriz2.length; j++) {
	        			System.out.printf("%.2f\t", matriz2[i][j]);
	        		}
	        	System.out.println();
	        	}
	        	System.out.println("-------------------------------------------");
	        	
	        	if (validacaoSoma == true) {
	        		System.out.println("A matriz SOMA é: ");
	        		for (int i = 0; i < matrizSoma.length; i++) {
	        			for (int j = 0; j < matrizSoma.length; j++) {
	        				System.out.printf("%.2f | ", matrizSoma[i][j]);
	        			}
	        		System.out.println();
	        		}
	        		System.out.println("-------------------------------------------");
	        	}
	        	
	        	if (validacaoSubt == true) {
	        		System.out.println("A matriz SUBTRAÇÃO é: ");
	        		for (int i = 0; i < matrizSubt.length; i++) {
	        			for (int j = 0; j < matrizSubt.length; j++) {
	        				System.out.printf("%.2f | ", matrizSubt[i][j]);
	        			}
	        		System.out.println();
	        		}
	        		System.out.println("-------------------------------------------");
	        	}
	        	validacaoSoma = false;
	        	validacaoSubt = false;
	        	validacaoConst = false;
	            break;
	            
	        // SAÍDA DO LOOPING DO MENU:
	        case "e":
				if (opcao.equals("e")) {
					saida = true;
				}
				break;
	            
	        // TRATAMENTO PARA OPÇÃO INVÁLIDA:
	        default:  
	        	System.out.println("OPÇÃO INVÁLIDA. FAVOR DIGITAR OUTRA OPÇÃO.");
	            System.out.println("-------------------------------------------");
			
			}// Chave de fechamanto do switch
			
		} while (saida == false);
		
		System.out.println("EXECUÇÃO ENCERRADA PELO USUÁRIO!!!");
	}
}