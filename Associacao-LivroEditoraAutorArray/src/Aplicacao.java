public class Aplicacao {

	public static void main(String[] args) {
		
		// Declaração do objeto "editora" da Classe Editora:
		Editora editora;
				
		// Instanciamento e atribuição dos dados do objeto "editora" da Classe Editora:
		editora = new Editora(111, "Editora Unit", "Aldo Moura", "(81) 1111-2222");
		
		// Criação do vetor "vetorAutores":
		Autor[] vetorAutores = new Autor[3];
		
		// Declaração do objeto "autor" da Classe Autor:
		Autor autor;
		
		// Instanciamento e atribuição dos dados do objeto "autor" da Classe Autor:
		autor = new Autor(100, "Pedro Gregório", "pedrogregorio@hotmail.com");
		
		// Atribuição dos dados do elemento[0] do vetor "vetorAutores":
		vetorAutores[0] = autor;
		
		// Instanciamento e atribuição dos dados do objeto "autor" da Classe Autor:
		autor = new Autor(200, "Samuel Oliveira", "samueloliveira@hotmail.com");
		
		// Atribuição dos dados do elemento[1] do vetor "vetorAutores":
		vetorAutores[1] = autor;
		
		// Instanciamento e atribuição dos dados do objeto "autor" da Classe Autor:
		// autor = new Autor(300, "Paulo Henrique", "paulohenrique@hotmail.com");
		
		// Atribuição dos dados do elemento[2] do vetor "vetorAutores":
		// vetorAutores[2] = autor;
		
		// Declaração do objeto "livro" da Classe Livro:
		Livro livro;
			
		// Instanciamento e atribuição dos dados do objeto "livro" da Classe Livro:
		livro = new Livro(1234, "Aprendendo POO", "978-3-16-148410-0", editora, vetorAutores);
		
		// Listar os dados do objeto "livro" com a razão social do objeto "editora" e os nomes dos objetos "autor":
		System.out.println("************* DADOS DO LIVRO *************");
		System.out.printf("Código do livro: %d\nTítulo do livro: %s\nCódido ISBN....: %s\nEditora........: %s\n",
		livro.getCodigo(), livro.getTitulo(), livro.getIsbn(), livro.getEditora().getRazaoSocial());
		
		// System.out.printf("Autor..........: %s\n", vetorAutores[0].getNome());
		// System.out.printf("Autor..........: %s\n", vetorAutores[1].getNome());
		// System.out.printf("Autor..........: %s\n", vetorAutores[2].getNome());
		
		int contador = 0;
		for (Autor i: livro.getAutores()) {
			
			if (i != null) { // Tratamento para não imprimir valores nulos (vetor incompleto)
			
				if (contador == 0) {
					System.out.print("Autor(es)......: " + i.getNome());
				} else {
					System.out.printf("\n                 " + i.getNome());
				}
				contador++;
			}
		}
		System.out.println("\n******************************************");

	}

}