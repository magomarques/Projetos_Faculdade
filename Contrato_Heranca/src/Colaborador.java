import java.util.Date;

public class Colaborador {

	private String matricula;
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private boolean situacao;
	
	// Método Construtor:
	
	public Colaborador() {
		this.situacao = false;
	}
	
	/*
	public Colaborador(String matricula, String cpf, String nome, Date dataNascimento) {
		super();
		this.matricula = matricula;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.situacao = false;
	}
	*/
	
	// Métodos solicitados pelo exercício:
	
	public boolean validarCpf() {
		
		boolean valido;
		
		int[] cpf = new int[11];
		
		for (int i = 0; i < this.cpf.length(); i++) {
			cpf[i] = Integer.parseInt(String.valueOf(this.cpf.charAt(i)));
		}
		
		int [] peso = {11,10,9,8,7,6,5,4,3,2};
        int primeirodigito = 0, segundodigito = 0;
        
        int resultado1 = cpf[0]*peso[1] + cpf[1]*peso[2] + cpf[2]*peso[3] +
                         cpf[3]*peso[4] + cpf[4]*peso[5] + cpf[5]*peso[6] +
                         cpf[6]*peso[7] + cpf[7]*peso[8] + cpf[8]*peso[9];
                       
        int resultado2 = cpf[0]*peso[0] + cpf[1]*peso[1] + cpf[2]*peso[2] +
                         cpf[3]*peso[3] + cpf[4]*peso[4] + cpf[5]*peso[5] +
                         cpf[6]*peso[6] + cpf[7]*peso[7] + cpf[8]*peso[8] +
                         cpf[9]*peso[9];
                       
        int resto1 = resultado1 % 11;
        int resto2 = resultado2 % 11;
        
        if (resto1 < 2){
            primeirodigito = 0;
            } else {
                primeirodigito = 11 - resto1;
            }
        
        if (resto2 < 2){
            segundodigito = 0;
            } else {
                segundodigito = 11 - resto2;
            }
        
        if (primeirodigito == cpf[9] && segundodigito == cpf[10]){
        	valido = true;
        } else {
        	valido = false;
        }
		return valido;
	}

	public void ativar() {
		this.situacao = true;
	}
	
	public void desativar() {
		this.situacao = false;
	}

	// Métodos Acessores e Modificadores:
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
}
