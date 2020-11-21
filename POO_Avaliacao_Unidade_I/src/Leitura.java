import java.util.Date;

public class Leitura {

	// Autoincremento da variável id:
	private static int sequencia = 1;
	
	// Atributos:
	private int    id;
	private Imovel imovel;
	private int    leitura;
	private Date   data;
	
	// Método Construtor:
	
	public Leitura(Imovel imovel, int leitura, Date data) {
		// Autoincremento do atributo id:
		this.id = sequencia++;
		
		// Autoincremento do atributo id (tem que ser static):
		// Não tem "this." pois por ser static é um atributo da classe e não do objeto:
		//id = id++;
		
		// Outros atributos:
		this.imovel = imovel;
		this.leitura = leitura;
		this.data = data;
	}
	
	// Método solicitado pelo exercício:
	
	public void registrarLeitura() {
		//this.imovel.calcularConsumo(leitura);
		//this.imovel.calcularConta();
		imovel.atualizarLeitura(leitura);
		
		
	}

	// Métodos Acessores e Modificadores:
	
	public int getId() {
		return id;
	}

	//public void setId(int id) {
	//	this.id = id;
	//}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public int getLeitura() {
		return leitura;
	}

	public void setLeitura(int leitura) {
		this.leitura = leitura;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
