public class Instrutor extends Pessoa{
	
	// Atributos:
			
	private int codInstrutor;
	private String rg;
	private String titulacao;
	
	// Método Construtor:
	
	public Instrutor() {
		
	}
	
	// Métodos Acessores e Modificadores:

	public int getCodInstrutor() {
		return codInstrutor;
	}

	public void setCodInstrutor(int codInstrutor) {
		this.codInstrutor = codInstrutor;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
}