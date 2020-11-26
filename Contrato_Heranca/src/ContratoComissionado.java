
public class ContratoComissionado extends Contrato{

	private float percComissao;
	private float ajudaCusto;
	
	// Método Construtor:
	
	public ContratoComissionado() {
		
	}
	
	/*
	public ContratoComissionado(Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo,
			float percComissao, float ajudaCusto) {
		super(dataInicio, dataEncerramento, colaborador, ativo);
		this.percComissao = percComissao;
		this.ajudaCusto = ajudaCusto;
	}
	*/

	// Método solicitado pelo exercício:
	
	public float calcVencimento(float vlFaturam) {
		float vencimento = (vlFaturam * percComissao/100) + ajudaCusto;
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
	
	public float getPercComissao() {
		return percComissao;
	}

	public void setPercComissao(float percComissao) {
		this.percComissao = percComissao;
	}

	public float getAjudaCusto() {
		return ajudaCusto;
	}

	public void setAjudaCusto(float ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}

}
