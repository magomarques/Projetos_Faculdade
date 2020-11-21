import java.util.Date;

public class Carrinho {

	// Atributos:
	
	private static int sequencia = 1;
	
	private int id;
	private Date data;
	private Produto[] itens = new Produto[3];
	private int numDeItens;
	private float valorICMS;
	private float valorVenda;
	private String status;
	
	// Método Construtor:
	
	public Carrinho() {
		this.id = sequencia++;
		this.status = "False";
	}
	
	// Métodos solicitados no exercício:
	
	public void insereItem(Produto p) {
		
		for (int i = 0; i < itens.length; i++) {
			if (itens[i] == null) {
				itens[i] = p;
				break;
			}
		}
		
		this.valorICMS += p.calcularICMS();
		
		this.valorVenda += p.getPrecoVenda(); 
	}
	
	public void confirmarCompra() {
		
		for (int i = 0; i < itens.length; i++) {
			if (this.itens[i] != null) {
				this.itens[i].confirmaVenda();
			}
		}
		
		this.status = "Confirmada";
	}

	// Métodos Acessores e Modificadores:
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Produto[] getItens() {
		return itens;
	}

	public void setItens(Produto[] itens) {
		this.itens = itens;
	}

	public int getNumDeItens() {
		return numDeItens;
	}

	public void setNumDeItens(int numDeItens) {
		this.numDeItens = numDeItens;
	}

	public float getValorICMS() {
		return valorICMS;
	}

	public void setValorICMS(float valorICMS) {
		this.valorICMS = valorICMS;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
