
public class ContratoAssalariado extends Contrato{

	private float salarioMensal;
	private float percInsalubridade;
	private float percPericulosidade;
	
	// Método Construtor:
	
	public ContratoAssalariado() {
		
	}
	
	/*
	public ContratoAssalariado(Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo,
			float salarioMensal, float percInsalubridade, float percPericulosidade) {
		super(dataInicio, dataEncerramento, colaborador, ativo);
		this.salarioMensal = salarioMensal;
		this.percInsalubridade = percInsalubridade;
		this.percPericulosidade = percPericulosidade;
	}
	*/

	// Método solicitado pelo exercício:
	
	public float calcVencimento() {
		float vencimento = salarioMensal + (salarioMensal * percInsalubridade/100) + (salarioMensal * percPericulosidade/100);
		return vencimento;
	}
	
	// Método abstrato:
	
	@Override
	public float calcularSeguro() {
		float valorSeguro = 0;
		// Implementar aqui o cálculo específico da subclasse
		return valorSeguro;
	}

	// Métodos Acessores e Modificadores:
	
	public float getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(float salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public float getPercInsalubridade() {
		return percInsalubridade;
	}

	public void setPercInsalubridade(float percInsalubridade) {
		this.percInsalubridade = percInsalubridade;
	}

	public float getPercPericulosidade() {
		return percPericulosidade;
	}

	public void setPercPericulosidade(float percPericulosidade) {
		this.percPericulosidade = percPericulosidade;
	}
	
}
