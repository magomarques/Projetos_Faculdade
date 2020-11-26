import java.util.Scanner;

public class JogoVelha {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String[][] tabuleiro = {{" "," "," "},{" "," "," "},{" "," "," "}};
		String[][] posicao = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		int contador = 0;
		String resultado = " ";
		boolean vencedor = false;
				
		
		// CONSTRUÇÃO DO TABULEIRO DO JOGO:
		System.out.println("-----------JOGO DA VELHA-----------");
		do {			
			if (contador == 0) {
				System.out.println("INÍCIO DO JOGO:");
			} else {
				System.out.println(+contador+"ª JOGADA:");
			}
			
			contador++;
			
			System.out.println("   TABULEIRO       POSIÇÃO");
			System.out.println("[ "+tabuleiro[0][0]+" ][ "+tabuleiro[0][1]+" ][ "+tabuleiro[0][2]+" ] - ["+posicao[0][0]+"]["+posicao[0][1]+"]["+posicao[0][2]+"]");
			System.out.println("[ "+tabuleiro[1][0]+" ][ "+tabuleiro[1][1]+" ][ "+tabuleiro[1][2]+" ] - ["+posicao[1][0]+"]["+posicao[1][1]+"]["+posicao[1][2]+"]");
			System.out.println("[ "+tabuleiro[2][0]+" ][ "+tabuleiro[2][1]+" ][ "+tabuleiro[2][2]+" ] - ["+posicao[2][0]+"]["+posicao[2][1]+"]["+posicao[2][2]+"]");
			
			System.out.println("-----------------------------------------------");
			
			// AÇÃO DOS JOGADORES 1 E 2:				
			boolean vaga = true;
						
			do {
				String marca = " ";
				
				if (contador % 2 != 0) {
					marca = "X";
				} else {
					marca = "O";
				}	
				
				// ENTRADA E TRATAMENTO DA COORDENADA (ACEITA APENAS DE 0 A 9 COMO DADO DE ENTRADA)
				String coordenada = " ";
				boolean validarCoordenada = false;
								
				do {
										
					System.out.print("Digite a POSIÇÃO da sua jogada JOGADOR '"+marca+"' : ");
					coordenada = entrada.next();
					
					if (coordenada.equals("1") || coordenada.equals("2") || coordenada.equals("3") ||
						coordenada.equals("4") || coordenada.equals("5") || coordenada.equals("6") || 
						coordenada.equals("7") || coordenada.equals("8") || coordenada.equals("9")) {
						validarCoordenada = true;
					} else {
						System.out.println("POSIÇÃO INVÁLIDA! DIGITE OUTRA POSIÇÃO!");
						System.out.println("-----------------------------------------------");
					}
					
				} while (validarCoordenada == false);
						
				// VERIFICAR SE A VAGA ESCOLHIDA ESTÁ VAZIA E PODE SER PREENCHIDA:
				if (coordenada.equals("1") && tabuleiro[0][0] == " ") {
					tabuleiro[0][0] = marca;
					posicao[0][0] = "-";
					vaga = true;
				} else if (coordenada.equals("2") && tabuleiro[0][1] == " ") {
					tabuleiro[0][1] = marca;
					posicao[0][1] = "-";
					vaga = true;
				} else if (coordenada.equals("3") && tabuleiro[0][2] == " ") {
					tabuleiro[0][2] = marca;
					posicao[0][2] = "-";
					vaga = true;
				} else if (coordenada.equals("4") && tabuleiro[1][0] == " ") {
					tabuleiro[1][0] = marca;
					posicao[1][0] = "-";
					vaga = true;
				} else if (coordenada.equals("5") && tabuleiro[1][1] == " ") {
					tabuleiro[1][1] = marca;
					posicao[1][1] = "-";
					vaga = true;
				} else if (coordenada.equals("6") && tabuleiro[1][2] == " ") {
					tabuleiro[1][2] = marca;
					posicao[1][2] = "-";
					vaga = true;
				} else if (coordenada.equals("7") && tabuleiro[2][0] == " ") {
					tabuleiro[2][0] = marca;
					posicao[2][0] = "-";
					vaga = true;
				} else if (coordenada.equals("8") && tabuleiro[2][1] == " ") {
					tabuleiro[2][1] = marca;
					posicao[2][1] = "-";
					vaga = true;
				} else if (coordenada.equals("9") && tabuleiro[2][2] == " ") {
					tabuleiro[2][2] = marca;
					posicao[2][2] = "-";
					vaga = true;
				} else {
					System.out.println("POSIÇÃO JÁ UTILIZADA! DIGITE OUTRA POSIÇÃO!");
					vaga = false;
				}
			System.out.println("-----------------------------------------------");
			
			} while (vaga == false);
			
			// VERIFICAÇÃO SE HÁ VENCEDOR:
			if (tabuleiro[0][0] != " " && tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][1] == tabuleiro[0][2]) {
				vencedor = true;
				resultado = tabuleiro[0][0];			
			} else if (tabuleiro[1][0] != " " && tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[1][2]) {
				vencedor = true;
				resultado = tabuleiro[1][0];
			} else if (tabuleiro[2][0] != " " && tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][1] == tabuleiro[2][2]) {
				vencedor = true;
				resultado = tabuleiro[2][0];
			} else if (tabuleiro[0][0] != " " && tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[1][0] == tabuleiro[2][0]) {
				vencedor = true;
				resultado = tabuleiro[0][0];
			} else if (tabuleiro[0][1] != " " && tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][1]) {
				vencedor = true;
				resultado = tabuleiro[0][1];
			} else if (tabuleiro[0][2] != " " && tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][2]) {
				vencedor = true;
				resultado = tabuleiro[0][2];
			} else if (tabuleiro[0][0] != " " && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
				vencedor = true;
				resultado = tabuleiro[0][0];
			} else if (tabuleiro[0][2] != " " && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
				vencedor = true;
				resultado = tabuleiro[0][2];
			}
						
			if (vencedor == true) {
				System.out.println(+contador+"ª JOGADA:");
				System.out.println("   TABULEIRO       POSIÇÃO");
				System.out.println("[ "+tabuleiro[0][0]+" ][ "+tabuleiro[0][1]+" ][ "+tabuleiro[0][2]+" ] - ["+posicao[0][0]+"]["+posicao[0][1]+"]["+posicao[0][2]+"]");
				System.out.println("[ "+tabuleiro[1][0]+" ][ "+tabuleiro[1][1]+" ][ "+tabuleiro[1][2]+" ] - ["+posicao[1][0]+"]["+posicao[1][1]+"]["+posicao[1][2]+"]");
				System.out.println("[ "+tabuleiro[2][0]+" ][ "+tabuleiro[2][1]+" ][ "+tabuleiro[2][2]+" ] - ["+posicao[2][0]+"]["+posicao[2][1]+"]["+posicao[2][2]+"]");
				System.out.println("-----------------------------------------------");
				System.out.println("FIM DE JOGO!!!");
				System.out.println("-----------------------------------------------");
				System.out.println("O vencedor foi o JOGADOR '"+resultado+"'!!!");
			} else if (contador == 9) {
				System.out.println(+contador+"ª JOGADA:");
				System.out.println("   TABULEIRO       POSIÇÃO");
				System.out.println("[ "+tabuleiro[0][0]+" ][ "+tabuleiro[0][1]+" ][ "+tabuleiro[0][2]+" ] - ["+posicao[0][0]+"]["+posicao[0][1]+"]["+posicao[0][2]+"]");
				System.out.println("[ "+tabuleiro[1][0]+" ][ "+tabuleiro[1][1]+" ][ "+tabuleiro[1][2]+" ] - ["+posicao[1][0]+"]["+posicao[1][1]+"]["+posicao[1][2]+"]");
				System.out.println("[ "+tabuleiro[2][0]+" ][ "+tabuleiro[2][1]+" ][ "+tabuleiro[2][2]+" ] - ["+posicao[2][0]+"]["+posicao[2][1]+"]["+posicao[2][2]+"]");
				System.out.println("-----------------------------------------------");		
				System.out.println("FIM DE JOGO!!!");
				System.out.println("-----------------------------------------------");
				System.out.println("JOGO EMPATADO!!!");
				vencedor = true;
			}
			
		} while (vencedor == false);
	}
}