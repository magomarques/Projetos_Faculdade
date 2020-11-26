package Matrizes;

import java.util.Scanner;

public class Exercicio04 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int[][] posicao = new int[3][3];
		int contador = 0, resultado = 0;
		boolean vencedor = false;
				
		
		// CONSTRUÇÃO DO TABULEIRO DO JOGO:
		System.out.println("----------------JOGO DA VELHA--------------");
		do {			
			if (contador == 0) {
				System.out.println("INÍCIO DO JOGO:");
			} else {
				System.out.println(+contador+"ª JOGADA:");
			}
			
			contador++;
			
			System.out.println("Coluna :   0    1    2");
			System.out.println("Linha 0: [ "+posicao[0][0]+" ][ "+posicao[0][1]+" ][ "+posicao[0][2]+" ]");
			System.out.println("Linha 1: [ "+posicao[1][0]+" ][ "+posicao[1][1]+" ][ "+posicao[1][2]+" ]");
			System.out.println("Linha 2: [ "+posicao[2][0]+" ][ "+posicao[2][1]+" ][ "+posicao[2][2]+" ]");
			
			System.out.println("-------------------------------------------");
			
			// AÇÃO DOS JOGADORES 1 E 2:
									
			boolean vaga = true;
						
			do {
			
				if (contador % 2 != 0) {
					System.out.println("JOGADOR 1: ");
				} else {
					System.out.println("JOGADOR 2: ");
				}	
					
				System.out.println("Digite a LINHA  da sua jogada: ");
				int i = entrada.nextInt();
				System.out.println("Digite a COLUNA da sua jogada: ");
				int j = entrada.nextInt();
			
			// VERIFICAR SE A VAGA ESCOLHIDA ESTÁ VAZIA E PODE SER PREENCHIDA:
				if (i < 0 || i > 2 || j < 0 || j > 2) {
					System.out.println("COORDENADAS INVÁLIDAS!");
					vaga = false;
				} else if (contador % 2 != 0 && posicao[i][j] == 0) {
					posicao[i][j] = 1;
					vaga = true;
				} else if (contador % 2 == 0 && posicao[i][j] == 0) {
					posicao[i][j] = 2;
					vaga = true;
				} else {
					System.out.println("VAGA OCUPADA! DIGITE OUTRAS COORDENADAS!");
					vaga = false;
				}
			System.out.println("-------------------------------------------");
			
			} while (vaga == false);
			
			// VERIFICAÇÃO SE HÁ VENCEDOR:
			if (posicao[0][0] != 0 && posicao[0][0] == posicao[0][1] && posicao[0][1] == posicao[0][2]) {
				vencedor = true;
				resultado = posicao[0][0];			
			} else if (posicao[1][0] != 0 && posicao[1][0] == posicao[1][1] && posicao[1][1] == posicao[1][2]) {
				vencedor = true;
				resultado = posicao[1][0];
			} else if (posicao[2][0] != 0 && posicao[2][0] == posicao[2][1] && posicao[2][1] == posicao[2][2]) {
				vencedor = true;
				resultado = posicao[2][0];
			} else if (posicao[0][0] != 0 && posicao[0][0] == posicao[1][0] && posicao[1][0] == posicao[2][0]) {
				vencedor = true;
				resultado = posicao[0][0];
			} else if (posicao[0][1] != 0 && posicao[0][1] == posicao[1][1] && posicao[1][1] == posicao[2][1]) {
				vencedor = true;
				resultado = posicao[0][1];
			} else if (posicao[0][2] != 0 && posicao[0][2] == posicao[1][2] && posicao[1][2] == posicao[2][2]) {
				vencedor = true;
				resultado = posicao[0][2];
			} else if (posicao[0][0] != 0 && posicao[0][0] == posicao[1][1] && posicao[1][1] == posicao[2][2]) {
				vencedor = true;
				resultado = posicao[0][0];
			} else if (posicao[0][2] != 0 && posicao[0][2] == posicao[1][1] && posicao[1][1] == posicao[2][0]) {
				vencedor = true;
				resultado = posicao[0][2];
			}
						
			if (vencedor == true) {
				System.out.println("FIM DE JOGO!!!");
				System.out.println("O vencedor foi o JOGADOR "+resultado+"!!!");
			}
			
			if (contador == 9) {
				vencedor = true;
				System.out.println("FIM DE JOGO!!! EMPATADO!!!");
			}
			
		} while (vencedor == false);

	}

}