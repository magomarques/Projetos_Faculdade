
public class ContratoHorista extends Contrato{

	private int horasMes;
	private float valorHora;
	
	// Método Construtor:
	
	public ContratoHorista() {
		
	}
	
	/*
	public ContratoHorista(Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo, int horasMes,
			float valorHora) {
		super(dataInicio, dataEncerramento, colaborador, ativo);
		this.horasMes = horasMes;
		this.valorHora = valorHora;
	}
	*/

	// Método solicitado pelo exercício:
	
	public float calcVencimento() {
		float vencimento = horasMes * valorHora;
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
	
	public int getHorasMes() {
		return horasMes;
	}

	public void setHorasMes(int horasMes) {
		this.horasMes = horasMes;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

}
