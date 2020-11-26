import java.util.ArrayList;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		// Instanciamento do objeto "editora" da Classe Editora:
		Editora editora;
						
		// Atribuição dos dados do objeto "editora" da Classe Editora:
		editora = new Editora(111, "Editora Unit", "Aldo Moura", "(81) 1111-2222");
		
		// Criação da lista "listaAutores":
		ArrayList<Autor> listaAutores = new ArrayList<Autor>();

		// Declaração do objeto "autor" da Classe Autor:
		Autor autor;
		
		// Atribuição dos dados do 1º objeto da Classe Autor:
		autor = new Autor(100, "Pedro Gregório", "pedrogregorio@hotmail.com");
		
		// Adicionar o 1º objeto na lista "listaAutores":
		listaAutores.add(autor);
		// listaAutores.add(new Autor(100, "Pedro Gregório", "pedrogregorio@hotmail.com"));
		
		// Atribuição dos dados do 2º objeto da Classe Autor:
		autor = new Autor(200, "Samuel Oliveira", "samueloliveira@hotmail.com");
		
		// Adicionar o 2º objeto na lista "listaAutores":
		listaAutores.add(autor);
		// listaAutores.add(new Autor(200, "Samuel Oliveira", "samueloliveira@hotmail.com"));
		
		// Instanciamento do objeto "livro" da Classe Livro:
		Livro livro;
									
		// Atribuição dos dados do objeto "livro" da Classe Livro:
		livro = new Livro(1234, "Aprendendo POO", "978-3-16-148410-0", editora, listaAutores);
				
		// Listar os dados do objeto "livro" com a razão social do objeto "editora" e os nomes dos objetos "autor":
		System.out.println("************* DADOS DO LIVRO *************");
		System.out.printf("Código do livro: %d\nTítulo do livro: %s\nCódido ISBN....: %s\nEditora........: %s\n", livro.getCodigo(), livro.getTitulo(), livro.getIsbn(), livro.getEditora().getRazaoSocial());
		
		System.out.print("Autores........: ");
		for (Autor i: livro.getAutores()) {
				System.out.printf("\n                 " + i.getNome());
		}
		System.out.println("\n******************************************");
	}				
			
}