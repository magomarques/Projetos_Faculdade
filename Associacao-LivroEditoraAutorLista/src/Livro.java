import java.util.ArrayList;

public class Livro {

	// Atributos:
	
	private int codigo;
	private String titulo;
	private String isbn;
	private Editora editora;
	private ArrayList<Autor> autores;
		
	// Método Construtor:
		
	public Livro(int codigo, String titulo, String isbn, Editora editora, ArrayList<Autor> autores) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.isbn = isbn;
		this.editora = editora;
		this.autores = autores;
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

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

}
