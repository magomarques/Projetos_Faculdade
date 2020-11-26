public class Livro {

	// Atributos:
	
	private int     codigo;
	private String  titulo;
	private String  isbn;
	private Editora editora;
	
	// Declaração do vetor (1ª opção):
	private Autor[] autores = {null, null, null};
	
	// Declaração do vetor (2ª opção):
	// private Autor[] autores = new Autor[3];
	
	
	// Método Construtor:
	
	public Livro(int codigo, String titulo, String isbn, Editora editora, Autor[] autores) {
		this.codigo  = codigo;
		this.titulo  = titulo;
		this.isbn    = isbn;
		this.editora = editora;
		this.autores = autores;
		
		// Posso usar um FOR dentro do método:
		// for (int i = 0; i < autores.length; i++) {
		//	this.autores[i] = null;
		// }
	}

	// Métodos Acessores e Modificadores:
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Autor[] getAutores() {
		return autores;
	}

	public void setAutores(Autor[] autores) {
		this.autores = autores;
	}	
}