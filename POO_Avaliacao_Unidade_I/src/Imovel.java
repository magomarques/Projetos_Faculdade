public class Imovel {

	// Atributos:
	
	private int    id;
	private String endereco;
	private char   tipo;
	private int    ultimaLeitura;
	private int    consumo;
	private float  valorConta;
	
	// Método Construtor:
	
	public Imovel(int id, String endereco, char tipo, int ultimaLeitura) {
		this.id = id;
		this.endereco = endereco;
		this.tipo = tipo;
		this.ultimaLeitura = ultimaLeitura;
		this.consumo = 0;
		this.valorConta = 0;
	}
	
	// Métodos solicitados pelo exercício:
	
	public void calcularConsumo(int leituraAtual){
		// return leituraAtual - this.ultimaLeitura;
		this.consumo = leituraAtual - ultimaLeitura;
	}
	
	public void calcularConta() {
		//float conta = 0f;
		if (tipo == 'C'){
			//conta = (float) (this.consumo * 0.70);
			this.valorConta = (float) (this.consumo * 0.70);
		} else if (tipo == 'I'){
			//conta = (float) (this.consumo * 0.40);
			this.valorConta = (float) (this.consumo * 0.40);
		} else if (tipo == 'R'){
			//conta = (float) (this.consumo * 0.50);
			this.valorConta = (float) (this.consumo * 0.50);
		}
		//return conta;
	}
	
	public void atualizarLeitura(int leituraAtual) {
		this.ultimaLeitura = leituraAtual;
	}

	// Métodos Acessores e Modificadores:
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public int getUltimaLeitura() {
		return ultimaLeitura;
	}

	//public void setUltimaLeitura(int ultimaLeitura) {
	//	this.ultimaLeitura = ultimaLeitura;
	//}

	public int getConsumo() {
		return consumo;
	}

	//public void setConsumo(int consumo) {
	//	this.consumo = consumo;
	//}

	public float getValorConta() {
		return valorConta;
	}

	//public void setValorConta(float valorConta) {
	//	this.valorConta = valorConta;
	//}
	
}
