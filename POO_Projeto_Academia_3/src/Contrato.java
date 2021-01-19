import java.util.Date;

public class Contrato {
	
	// Atributos:
	
	private int codContrato;
	private String plano;
	private Date dataInicio;
	private Date dataTermino;
	private Aluno aluno;
	private int codCobranca;
	
	// Método construtor:
	
	public Contrato() {

	}

	// Métodos Acessores e Modificadores:

	public int getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public int getCodCobranca() {
		return codCobranca;
	}

	public void setCodCobranca(int codCobranca) {
		this.codCobranca = codCobranca;
	}
	
}
