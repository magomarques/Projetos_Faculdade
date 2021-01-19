import java.util.Date;

public class Agendamento {
	
	// Atributos:

	private int codAgendamento;
	private Date dataAgendamento;
	private Date horaAgendamento;
	
	// Método Construtor:
	
	public Agendamento() {
		
	}

	// Métodos Acessores e Modificadores:
	
	public int getCodAgendamento() {
		return codAgendamento;
	}

	public void setCodAgendamento(int codAgendamento) {
		this.codAgendamento = codAgendamento;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Date getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(Date horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}
	
}
