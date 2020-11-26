
public class VendaComissionada {

	private int id;
	private int mes;
	private int ano;
	private float valor;
	private ContratoComissionado contrComissionado;
	
	// Métodos Acessores e Modificadores:
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public ContratoComissionado getContrComissionado() {
		return contrComissionado;
	}
	public void setContrComissionado(ContratoComissionado contrComissionado) {
		this.contrComissionado = contrComissionado;
	}
	
}
