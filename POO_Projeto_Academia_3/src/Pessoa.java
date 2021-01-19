import java.util.Date;

public abstract class Pessoa {

	// Atributos:
	
	private String nome;
	private Date dataNascimento;
	
	// Métodos Acessores e Modificadores:
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
