package Vetores;

public class Exercicio07 {

	public static void main(String[] args) {
		
		int[] vetor = new int [50];
        
		// GERAR UM VETOR COM 50 ELEMENTOS OBTIDOS PELA FÓRMULA (i + 5 * i) % (i + 1):
		// CONSIDEREI EXATAMENTE COMO A FÓRMULA ( % = RESTO DA DIVISÃO):
        System.out.println("Vetor gerado: ");
        for (int i = 0; i < vetor.length; i++){
            vetor[i] = (i+5*i)%(i+1);
                System.out.println("Posição ["+(i+1)+"] = " +vetor[i]);
        }

	}

}
