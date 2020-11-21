
public class Produto {

	// Atributos:
	
	private int codigo;
	private String descricao;
	private float precoVenda;
	private float aliquotaICMS;
	private boolean vendido;
	
	// Métodos solicitados no exercício:
	
	public float calcularICMS() {
		return this.precoVenda * this.aliquotaICMS/100;
	}
	
	public void confirmaVenda() {
		this.vendido = true;
	}

	// Métodos Acessores e Modificadores:
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public float getAliquotaICMS() {
		return aliquotaICMS;
	}

	public void setAliquotaICMS(float aliquotaICMS) {
		this.aliquotaICMS = aliquotaICMS;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
}
