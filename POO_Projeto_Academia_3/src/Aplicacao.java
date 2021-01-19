import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Aplicacao {
	
	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	static SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");
		 
	static Scanner entrada = new Scanner(System.in);
	
	static ConexaoBD conexaoBD = new ConexaoBD();

	public static void main(String[] args) throws ParseException{
		
		String opcao = "";
		boolean repeticao = true;
		
		do {
			
			System.out.println("============ MENU DE ACESSO PRINCIPAL ============");
			System.out.println("1) Cadastrar Aluno");
			System.out.println("2) Cadastrar Instrutor");
			System.out.println("3) Manter Atividade");
			System.out.println("4) Registrar Agendamento");
			System.out.println("5) Registrar Matrícula");
			System.out.println("6) Consultar Matrícula");
			System.out.println("7) Consultar Agendamento");
			System.out.println("8) Listar alunos");
			System.out.println("0) Finalizar");
			System.out.println("--------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			opcao = entrada.next();
			System.out.println("--------------------------------------------------");
			
			// Limpar o Buffer:
			entrada.nextLine();
				
			switch (opcao){
				
				case "1":
					cadastrarAluno();
				break;
					
				case "2":
					cadastrarInstrutor();
				break;
					
				case "3":
					manterAtividade();
				break;
				
				case "4":
					registrarAgendamento();
				break;
					
				case "5":
					registrarMatricula();
				break;
					
				case "6":
					consultarMatricula();
				break;
				
				case "7":
					consultarAgendamento();
				break;
				
				case "8":
					conexaoBD.listarAlunos();
				break;
					
				case "0":
					System.out.println("EXECUÇÃO FINALIZADA.");
					repeticao = false;
				break;
					
				default:
					System.out.println("OPÇÃO INVÁLIDA! DIGITE UMA OPÇÃO VÁLIDA!");
					System.out.println("--------------------------------------------------");
				break;
			
			}
				
		} while (repeticao == true);

	} // Final do método main.
	
	// SUB-ROTINAS:
	
	// 1) Método cadastrar aluno:
	public static void cadastrarAluno() throws ParseException{
		
		Aluno aluno = new Aluno();
		
		// Gerar a data de hoje:
		Date hoje = new Date();
		
		aluno.setDataMatricula(hoje);
		
		System.out.println("Data da matrícula.: " + formato.format(aluno.getDataMatricula()));
		
		System.out.print("Nome..............: ");
		aluno.setNome(entrada.nextLine());
		
		System.out.print("Endereço..........: ");
		aluno.setEndereco(entrada.nextLine());
		
		boolean validaTelefone = false;
		do {
			System.out.print("Telefone..........: ");
			String telefone = entrada.nextLine();
						
			if (telefone.length() <= 12) {
				aluno.setTelefone(telefone);
				validaTelefone = true;
			} else {
				System.out.println("Erro: Digite no formato apresentado.");
				System.out.println("Formato de entrada: MÁXIMO DE 12 CARACTERES");
			}
			
		} while (validaTelefone == false);
		
		boolean valido1 = true;
		do {
			try {
				System.out.print("Data de nascimento: ");
				Date data = formato.parse(entrada.nextLine());
				aluno.setDataNascimento(data);
				valido1 = true;
			} catch (Exception erro) {
				System.out.println("Erro: Dado de entrada inválido.");
				valido1 = false;
			}
		} while (valido1 == false);
		
		boolean valido2 = true;
		do {
			try {
				System.out.print("Altura............: ");
				aluno.setAltura(entrada.nextFloat());
				valido2 = true;
			} catch (Exception erro) {
				System.out.println("Erro: Dado de entrada inválido.");
				valido2 = false;
				// Limpar o Buffer:
				entrada.nextLine();
			}
		} while (valido2 == false);
		
		boolean valido3 = true;
		do {
			try {
				System.out.print("Peso..............: ");
				aluno.setPeso(entrada.nextFloat());
				valido3 = true;
			} catch (Exception erro) {
				System.out.println("Erro: Dado de entrada inválido.");
				valido3 = false;
				// Limpar o Buffer:
				entrada.nextLine();
			}
		} while (valido3 == false);
		
		conexaoBD.cadastrarAluno(aluno);
		conexaoBD.informarMatricula(aluno.getNome());
	}
	
	// 2) Método cadastrar instrutor:
	public static void cadastrarInstrutor() throws ParseException{
			
		Instrutor instrutor = new Instrutor();
		
		System.out.print("Nome..............: ");
		instrutor.setNome(entrada.nextLine());
			
		boolean valido1 = true;
		do {
			try {
				System.out.print("Data de nascimento: ");
				Date data = formato.parse(entrada.nextLine());
				instrutor.setDataNascimento(data);
				valido1 = true;
			} catch (Exception erro) {
				System.out.println("Erro: Dado de entrada inválido.");
				valido1 = false;
			}
		} while (valido1 == false);
		
		boolean validaRG = false;
		do {
			System.out.print("RG................: ");
			String rg = entrada.nextLine();
			
			if (rg.length() <= 9) {
				instrutor.setRg(rg);
				validaRG = true;
			} else {
				System.out.println("Erro: Digite no formato apresentado.");
				System.out.println("Formato de entrada: MÁXIMO DE 9 CARACTERES");
			}
			
		} while (validaRG == false);
		
		boolean validaTitulacao = false;
		do {
			System.out.print("Titulação.........: ");
			String titulacao = entrada.nextLine();
		
			if (titulacao.equals("GRADUACAO") || titulacao.equals("TECNOLOGO") || titulacao.equals("POS-GRADUACAO") || titulacao.equals("MESTRADO")) {
				instrutor.setTitulacao(titulacao);
				validaTitulacao = true;
			} else {
				System.out.println("Erro: Digite no formato apresentado.");
				System.out.println("Formato de entrada: GRADUACAO/TECNOLOGO/POS-GRADUACAO/MESTRADO");
			}
			
		} while (validaTitulacao == false);
		
		conexaoBD.cadastrarInstrutor(instrutor);
	}
	
	// 3) Método manter atividade:
	public static void manterAtividade() throws ParseException{
		
		String opcao = "";
		boolean repeticao = true;
		
		do {
			System.out.println("========== SUBMENU DE ACESSO ATIVIDADE ===========");
			System.out.println("1) Cadastrar Atividade");
			System.out.println("2) Consultar Atividades");
			System.out.println("3) Alterar Atividade");
			System.out.println("4) Excluir Atividade");
			System.out.println("0) Finalizar");
			System.out.println("--------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			opcao = entrada.next();
			System.out.println("--------------------------------------------------");
			
			// Limpar o Buffer:
			entrada.nextLine();
				
			switch (opcao){
			
				case "1":
					Atividade atividade = new Atividade();
					
					boolean validaAtividade = false;
					do {
						System.out.print("Nome...............: ");
						String nomeAtividade = entrada.nextLine();
					
						if (nomeAtividade.equals("CORRIDA") || nomeAtividade.equals("JIU JITSU") || nomeAtividade.equals("MUSCULACAO") 
								|| nomeAtividade.equals("AEROBICO") || nomeAtividade.equals("JUDO")|| nomeAtividade.equals("DANCA")) {
							atividade.setNomeAtividade(nomeAtividade);
							validaAtividade = true;
						} else {
							System.out.println("Erro: Digite no formato apresentado.");
							System.out.println("Formato de entrada.: CORRIDA/JIU JITSU/MUSCULACAO/AEROBICO/JUDO/DANCA");
						}
						
					} while (validaAtividade == false);
					
					conexaoBD.cadastrarAtividade(atividade);
				break;
				
				case "2":
					conexaoBD.consultarAtividade();
				break;
				
				case "3":
					System.out.print("Código da Atividade.......: ");
					int codigo = entrada.nextInt();
					
					// Limpar o Buffer:
					entrada.nextLine();
							
					boolean validaAtividade2 = false;
					do {
						System.out.print("Nome da nova atividade....: ");
						String nomeAtividade = entrada.nextLine();
						
						if (nomeAtividade.equals("CORRIDA") || nomeAtividade.equals("JIU JITSU") || nomeAtividade.equals("MUSCULACAO") 
								|| nomeAtividade.equals("AEROBICO") || nomeAtividade.equals("JUDO")|| nomeAtividade.equals("DANCA")) {
							conexaoBD.alterarAtividade(codigo, nomeAtividade);
							validaAtividade2 = true;
						} else {
							System.out.println("Erro: Digite no formato apresentado.");
							System.out.println("Formato de entrada.: CORRIDA/JIU JITSU/MUSCULACAO/AEROBICO/JUDO/DANCA");
						}
							
					} while (validaAtividade2 == false);
				break;
				
				case "4":
					System.out.print("Código da Atividade: ");
					codigo = entrada.nextInt();
					
					conexaoBD.excluirAtividade(codigo);
				break;
					
				case "0":
					System.out.println("RETORNO AO MENU PRINCIPAL.");
					System.out.println("--------------------------------------------------");
					repeticao = false;
				break;
					
				default:
					System.out.println("OPÇÃO INVÁLIDA. DIGITE UMA OPÇÃO VÁLIDA.");
					System.out.println("--------------------------------------------------");
				break;
			
			}
			
		} while (repeticao == true);
	}
	
	// 4) Método registrar agendamento:
	public static void registrarAgendamento() throws ParseException{
			
		System.out.print("Matrícula do aluno.: ");
		int matricula = entrada.nextInt();
		
		// Limpar o Buffer:
		entrada.nextLine();
		
		// Gerar a data de hoje:
		Date hoje = new Date();
		
		Agendamento agendamento = new Agendamento();
				
		boolean valido1 = false;
		do {
			try {
				System.out.print("Data do agendamento: ");
				Date dataAgendamento = formato.parse(entrada.nextLine());
						
				if (dataAgendamento.after(hoje) == true) {
					agendamento.setDataAgendamento(dataAgendamento);
					valido1 = true;
				} else {
					System.out.println("Erro: Dado de entrada inválido.");
				}
					
			} catch (Exception erro) {
				System.out.println("Erro: Dado de entrada inválido.");
				System.out.println("Formato de entrada.: DD/MM/YYYY");
				valido1 = false;
			}
		} while (valido1 == false);
				
		boolean valido2 = false;
		do {
			try {
				System.out.print("Hora do agendamento: ");
				Date hora = sdhora.parse(entrada.nextLine());
				agendamento.setHoraAgendamento(hora);
				valido2 = true;
			} catch (Exception erro) {
				System.out.println("Erro: Dado de entrada inválido.");
				System.out.println("Formato de entrada.: HH:MM:SS");
				valido2 = false;
			}
		} while (valido2 == false);
		
		conexaoBD.cadastrarAgendamento(matricula, agendamento);
	}
	
	// 5) Método registrar matrícula:
	public static void registrarMatricula() {
		
		System.out.print("Matrícula do aluno.......: ");
		int matricula = entrada.nextInt();
		
		// Limpar o Buffer:
		entrada.nextLine();
		
		// Gerar a data de hoje:
		Date hoje = new Date();
		
		Contrato contrato = new Contrato();
				
		boolean validaPlano = false;
		do {
			System.out.print("Plano....................: ");
			String plano = entrada.nextLine();
		
			if (plano.equals("OURO") || plano.equals("PRATA") || plano.equals("BRONZE")) {
				contrato.setPlano(plano);
				validaPlano = true;
			} else {
				System.out.println("Erro: Digite no formato apresentado.");
				System.out.println("Formato de entrada.......: OURO/PRATA/BRONZE");
			}
			
		} while (validaPlano == false);
		
		boolean validaData = false;
		do {
			try {
				System.out.print("Data de início...........: ");
				Date dataInicio = formato.parse(entrada.nextLine());
				
				if (dataInicio.after(hoje) == true) {
					contrato.setDataInicio(dataInicio);
					validaData = true;
				} else {
					System.out.println("Erro: Dado de entrada inválido.");
				}
				
			} catch (Exception erro) {
				System.out.println("Erro: Dado de entrada inválido.");
				validaData = false;
			}
		} while (validaData == false);
		
		boolean validaData2 = false;
		do {
			try {
				
				System.out.print("Data de término..........: ");
				Date dataTermino = formato.parse(entrada.nextLine());
				
				if (dataTermino.after(contrato.getDataInicio()) == true) {
					contrato.setDataTermino(dataTermino);
					validaData2 = true;
				} else {
					System.out.println("Erro: Dado de entrada inválido.");
				}
				
			} catch (Exception erro) {
				System.out.println("Erro: Dado de entrada inválido.");
				validaData2 = false;
			}
		} while (validaData2 == false);
		
		conexaoBD.registrarMatricula(matricula, contrato);		
	}
	
	// 6) Método consultar matrícula:
	public static void consultarMatricula() {
		
		System.out.print("Matrícula do aluno.: ");
		int matricula = entrada.nextInt();
		
		conexaoBD.consultarMatricula(matricula);
		conexaoBD.consultarContrato(matricula);
	}
	
	// 7) Método consultar agendamento:
	public static void consultarAgendamento() {
		
		System.out.print("Matrícula do aluno...: ");
		int matricula = entrada.nextInt();
		
		conexaoBD.consultarAgendamento(matricula);
	}

} // Final do código