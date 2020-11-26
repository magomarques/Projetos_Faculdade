import java.util.Date;

public abstract class Contrato {

	private static int sequencia = 1000;
	
	private int id;
	private Date dataInicio;
	private Date dataEncerramento;
	private Colaborador colaborador;
	private boolean ativo;
	
	// Método Construtor:
	
	public Contrato() {
		this.id = sequencia++;
		this.ativo = true;
		//this.colaborador = colaborador; //OBS.: Tem que colocar o Colaborador como parâmetro do método.
		//this.colaborador.ativar();
	}
	
	/*
	public Contrato(Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo) {
		this.id = sequencia++;
		this.dataInicio = dataInicio;
		this.dataEncerramento = dataEncerramento;
		this.colaborador = colaborador;
		this.ativo = true;
		this.colaborador.ativar();
	}
	*/

	// Método solicitado pelo exercício:
	
	public void encerrarContrato() {
		this.ativo = false;
	}
	
	// Método abstrato:
	
	public abstract float calcularSeguro();

	// Métodos Acessores e Modificadores:
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
