import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Aplicacao {
	
	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
	 
	static Scanner entrada = new Scanner(System.in);
	
	static List<Colaborador> listaColaboradores = new ArrayList<Colaborador>();
	
	static List<Contrato> listaContratos = new ArrayList<Contrato>();
	
	static List<VendaComissionada> listaVendas = new ArrayList<VendaComissionada>();

	public static void main(String[] args) throws ParseException{
		
		String opcao = "";
		boolean repeticao = true;
		
		do {
		
			System.out.println("================= MENU DE ACESSO =================");
			System.out.println("1) Inserir colaborador");
			System.out.println("2) Registrar contrato");
			System.out.println("3) Consultar contrato");
			System.out.println("4) Encerrar contrato");
			System.out.println("5) Listar colaboradores ativos");
			System.out.println("6) Consultar contratos do colaborador");
			System.out.println("7) Lançar venda comissionada");
			System.out.println("8) Emitir folha de pagamento");
			System.out.println("0) Finalizar");
			System.out.println("--------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			opcao = entrada.next();
			System.out.println("--------------------------------------------------");
			
			// Limpar o Buffer:
			entrada.nextLine();
				
			switch (opcao){
				
				case "1":
					inserirColaborador();
				break;
					
				case "2":
					registrarContrato();
				break;
				
				case "3":
					consultarContrato();
				break;
				
				case "4":
					encerrarContrato();
				break;
					
				case "5":
					listarColaboradoresAtivos();
				break;
					
				case "6":
					consultarContratoColaborador();
				break;
				
				case "7":
					lancarVendasComissionadas();
				break;
						
				case "8":
					emitirFolhaPagamanto();
				break;
					
				case "0":
					System.out.println("EXECUÇÃO FINALIZADA!");
					repeticao = false;
				break;
					
				default:
					System.out.println("OPÇÃO INVÁLIDA! DIGITE UMA OPÇÃO VÁLIDA!");
				break;
			
			}
				
		} while (repeticao == true);

	} // Final do método main.
	
	// SUB-ROTINAS:
	
	public static void inserirColaborador() throws ParseException{
		
		boolean repeticao;
		boolean validacaoMatricula;
		boolean validacaoCpf;
		boolean repeticaoGeral;
		int contador = 0;
		
		Colaborador colaborador = new Colaborador();
		
		do {
			repeticao = true;
			validacaoMatricula = true;
			repeticaoGeral = true;
			
			if (contador > 0) {
				// Limpar o Buffer:
				entrada.nextLine();
			}
				
			contador++;
				
			System.out.print("Digite a matrícula do colaborador: ");
			String matricula = entrada.nextLine();
			
			for (int i = 0; i < matricula.length(); i++) {
				if (matricula.charAt(i) == '0' || matricula.charAt(i) == '1' ||
					matricula.charAt(i) == '2' || matricula.charAt(i) == '3' ||
					matricula.charAt(i) == '4' || matricula.charAt(i) == '5' ||
					matricula.charAt(i) == '6' || matricula.charAt(i) == '7' ||
					matricula.charAt(i) == '8' || matricula.charAt(i) == '9') {
				} else {
					validacaoMatricula = false;
					break;
				}
			}
			
			for (Colaborador i: listaColaboradores) {
				if (matricula.equalsIgnoreCase(i.getMatricula())) {
					validacaoMatricula = false;
				}
			}
			
			
			if (validacaoMatricula == true) {
				colaborador.setMatricula(matricula);
				repeticao = false;
				repeticaoGeral = true;
			}
				
			if (repeticao == true) {
				System.out.println("Matrícula inválida ou já cadastrada. Digite outra matrícula.");
						
				System.out.print("Deseja retornar ao menu principal? (S/N):");
				String menu = entrada.next();
					
				if (menu.equalsIgnoreCase("S")) {
					repeticao = false;
					repeticaoGeral = false;
				} else {
					repeticao = true;
				}
					
			}
				
		} while (repeticao == true);
		
		if (repeticaoGeral == true) {
		
		contador = 0;
			
		do {
			repeticao = true;
			validacaoCpf = true;
			
			if (contador > 0) {
				// Limpar o Buffer:
				entrada.nextLine();
			}
			
			contador++;
			
			System.out.print("Digite o CPF do colaborador: ");
			String cpf = entrada.nextLine();
			
			for (Colaborador i: listaColaboradores) {
				if (cpf.equalsIgnoreCase(i.getCpf())) {
					validacaoCpf = false;
				}
			}
			
			colaborador.setCpf(cpf);
			
			if (colaborador.validarCpf() == true && validacaoCpf == true) {
				repeticao = false;
			}
			
			if (repeticao == true) {
				System.out.println("CPF inválido ou já cadastrado. Digite outro CPF.");
						
				System.out.print("Deseja retornar ao menu principal? (S/N):");
				String menu = entrada.next();
					
				if (menu.equalsIgnoreCase("S")) {
					repeticao = false;
					repeticaoGeral = false;
				} else {
					repeticao = true;
				}
					
			}
			
		} while (repeticao == true);
		
		if (repeticaoGeral == true) {
		
		System.out.print("Digite o nome do colaborador: ");
		colaborador.setNome(entrada.nextLine());
		
			do {
				repeticao = true;
			
				System.out.print("Digite a data de nascimento do colaborador: ");
				Date data = formato.parse(entrada.nextLine());
			
				// Cálculo da idade (em anos) do colaborador:
				Date hoje = new Date();
				String hojeFormatado = formato.format(hoje);
				Date dataHoje = formato.parse(hojeFormatado);
			
				long diferenca = Math.abs(dataHoje.getTime() - data.getTime());
				int idadeDias = (int) (diferenca / (1000 * 60 * 60 * 24));
			
				if (idadeDias >= 6575){
					colaborador.setDataNascimento(data);
					repeticao = false;
				} else {
					System.out.println("Colaborador menor de idade. Digite outra data.");
				}
			
			} while (repeticao == true);
		
			listaColaboradores.add(colaborador);
		
			System.out.println("Colaborador inserido com sucesso.");
		
		}
		
	}
		
	} // Final do método inserirColaborador.
	
	public static void registrarContrato() throws ParseException{
		
		String opcao;
		String matricula;
		boolean repeticao;
		boolean repeticaoGeral;
		boolean validacaoData;
		boolean contratoAtivo;
		Date dataInicio;
		
		Date hoje = new Date();
		String hojeFormatado = formato.format(hoje);
		Date dataHoje = formato.parse(hojeFormatado);
		
		System.out.println("Digite o tipo de contrato que deseja registrar:");
		System.out.println("1) Contrato assalariado");
		System.out.println("2) Contrato comissionado");
		System.out.println("3) Contrato horista");
		System.out.println("--------------------------------------------------");
		System.out.print("Digite a opção desejada: ");
		opcao = entrada.next();
		System.out.println("--------------------------------------------------");
		
		if (opcao.equals("1")) {
			
			ContratoAssalariado contrato = new ContratoAssalariado();
			//contrato.setDataInicio(dataHoje);
			
			System.out.println("Número do contrato assalariado: " +contrato.getId());
			
			do {
				repeticao = true;
				repeticaoGeral = true;
				
				do {
					contratoAtivo = false;
					
					System.out.print("Digite a matrícula do colaborador: ");
					matricula = entrada.next();
				
					for (Contrato i: listaContratos) {
						if (matricula.equalsIgnoreCase(i.getColaborador().getMatricula())) {
							if (i.isAtivo() == true) {
								contratoAtivo = true;
								System.out.println("Colaborador já possui um contrato ativo.");
							}
						}
					}
				
				} while(contratoAtivo == true);
				
				for (Colaborador i: listaColaboradores) {
					if (matricula.equalsIgnoreCase(i.getMatricula())) {
						contrato.setColaborador(i);
						i.ativar();
						repeticao = false;
					}
				}
				
				if (repeticao == true) {
					System.out.println("Colaborador não registrado.");
				
					System.out.print("Deseja retornar ao menu principal? (S/N):");
					String menu = entrada.next();
					
					if (menu.equalsIgnoreCase("S")) {
						repeticao = false;
						repeticaoGeral = false;
					} else {
						repeticao = true;
					}
					
				}
			
			} while (repeticao == true);
				
			// Limpar o Buffer:
			entrada.nextLine();
			
		if (repeticaoGeral == true) {
			
			do {
				repeticao = true;
				
				System.out.print("Digite a data de início do contrato: ");
				dataInicio = formato.parse(entrada.nextLine());
				
				if (dataInicio.after(dataHoje) == true) {
					contrato.setDataInicio(dataInicio);
					repeticao = false;
				} else {
					System.out.println("Digite uma data posterior a data atual.");
				}
			} while (repeticao == true);
			
			System.out.print("Digite o salário mensal do colaborador: ");
			contrato.setSalarioMensal(entrada.nextFloat());
			
			String resposta;
			
			System.out.print("O colaborador tem direito ao percentual de insalubridade? (S/N): ");
			resposta = entrada.next();
			
			if (resposta.equalsIgnoreCase("S")) {
				System.out.print("Digite o percentual de insalubridade do colaborador: ");
				contrato.setPercInsalubridade(entrada.nextFloat());
			} else {
				contrato.setPercInsalubridade(0);
			}
			
			System.out.print("O colaborador tem direito ao percentual de periculosidade? (S/N): ");
			resposta = entrada.next();
			
			if (resposta.equalsIgnoreCase("S")) {
				System.out.print("Digite o percentual de periculosidade do colaborador: ");
				contrato.setPercPericulosidade(entrada.nextFloat());
			} else {
				contrato.setPercPericulosidade(0);
			}
			
			listaContratos.add(contrato);
			
			System.out.println("Contrato registrado com sucesso.");
			
			}
			
		}
		
		if (opcao.equals("2")) {
			
			ContratoComissionado contrato = new ContratoComissionado();
			//contrato.setDataInicio(dataHoje);
			
			System.out.println("Número do contrato comissionado: " +contrato.getId());
			
			do {
				repeticao = true;
				repeticaoGeral = true;
				
				do {
					contratoAtivo = false;
					
					System.out.print("Digite a matrícula do colaborador: ");
					matricula = entrada.next();
				
					for (Contrato i: listaContratos) {
						if (matricula.equalsIgnoreCase(i.getColaborador().getMatricula())) {
							if (i.isAtivo() == true) {
								contratoAtivo = true;
								System.out.println("Colaborador já possui um contrato ativo.");
							}
						}
					}
				
				} while(contratoAtivo == true);
			
				for (Colaborador i: listaColaboradores) {
					if (matricula.equalsIgnoreCase(i.getMatricula())) {
						contrato.setColaborador(i);
						i.ativar();
						repeticao = false;
					}
				}
				
				if (repeticao == true) {
					System.out.println("Colaborador não registrado.");
					
					System.out.print("Deseja retornar ao menu principal? (S/N):");
					String menu = entrada.next();
					
					if (menu.equalsIgnoreCase("S")) {
						repeticao = false;
						repeticaoGeral = false;
					} else {
						repeticao = true;
					}
					
				}
			
			} while (repeticao == true);
			
			// Limpar o Buffer:
			entrada.nextLine();
			
		if (repeticaoGeral == true) {
			
			do {
				validacaoData = false;
				
				System.out.print("Digite a data de início do contrato: ");
				dataInicio = formato.parse(entrada.nextLine());
				
				if (dataInicio.after(dataHoje) == true) {
					contrato.setDataInicio(dataInicio);
					validacaoData = true;
				} else {
					System.out.println("Digite uma data posterior a data atual.");
				}
			} while (validacaoData == false);
						
			System.out.print("Digite o percentual de comissão do colaborador: ");
			contrato.setPercComissao(entrada.nextFloat());
			
			System.out.print("Digite a ajuda de custo do colaborador: ");
			contrato.setAjudaCusto(entrada.nextFloat());
			
			listaContratos.add(contrato);
			
			System.out.println("Contrato registrado com sucesso.");
			
			}
			
		}
		
		if (opcao.equals("3")) {
			
			ContratoHorista contrato = new ContratoHorista();
			//contrato.setDataInicio(dataHoje);
			
			System.out.println("Número do contrato horista: " +contrato.getId());
			
			do {
				repeticao = true;
				repeticaoGeral = true;
				
				do {
					contratoAtivo = false;
					
					System.out.print("Digite a matrícula do colaborador: ");
					matricula = entrada.next();
				
					for (Contrato i: listaContratos) {
						if (matricula.equalsIgnoreCase(i.getColaborador().getMatricula())) {
							if (i.isAtivo() == true) {
								contratoAtivo = true;
								System.out.println("Colaborador já possui um contrato ativo.");
							}
						}
					}
				
				} while(contratoAtivo == true);
			
				for (Colaborador i: listaColaboradores) {
					if (matricula.equalsIgnoreCase(i.getMatricula())) {
						contrato.setColaborador(i);
						i.ativar();
						repeticao = false;
					}
				}
				
				if (repeticao == true) {
					System.out.println("Colaborador não registrado.");
					
					System.out.print("Deseja retornar ao menu principal? (S/N):");
					String menu = entrada.next();
					
					if (menu.equalsIgnoreCase("S")) {
						repeticao = false;
						repeticaoGeral = false;
					} else {
						repeticao = true;
					}
				}
			
			} while (repeticao == true);
			
			// Limpar o Buffer:
			entrada.nextLine();
			
		if (repeticaoGeral == true) {
			
			do {
				validacaoData = false;
				
				System.out.print("Digite a data de início do contrato: ");
				dataInicio = formato.parse(entrada.nextLine());
				
				if (dataInicio.after(dataHoje) == true) {
					contrato.setDataInicio(dataInicio);
					validacaoData = true;
				} else {
					System.out.println("Digite uma data posterior a data atual.");
				}
			} while (validacaoData == false);
						
			System.out.print("Digite a quantidade de horas mensais de trabalho do colaborador: ");
			contrato.setHorasMes(entrada.nextInt());
			
			System.out.print("Digite o valor da hora de trabalho do colaborador: ");
			contrato.setValorHora(entrada.nextFloat());
			
			listaContratos.add(contrato);
			
			System.out.println("Contrato registrado com sucesso.");
			
			}
		
		}
		
	} // Final do método registrarContrato

	public static void consultarContrato() throws ParseException{
	
		System.out.print("Digite o id do contrato para consulta: ");
		int cod = entrada.nextInt();
		
		boolean validacao = false;
		
		for (Contrato i: listaContratos) {
			if (cod == i.getId()) {
				System.out.println("*** Informações Gerais do Contrato ***");
				
				
				String dataInicio = formato.format(i.getDataInicio());
				System.out.println("Data de início..........: " +dataInicio);
				
				if (i.getDataEncerramento() == null) {
					System.out.println("Data de encerramento....: N/A");
				} else {
					String dataEncerramento = formato.format(i.getDataEncerramento());
					System.out.println("Data de encerramento....: " +dataEncerramento);
				}
				
				if (i.isAtivo() == true) {
					System.out.println("Situação do contrato....: ativo");
				} else {
					System.out.println("Situação do contrato....: inativo");
				}
				
				if (i instanceof ContratoAssalariado) {
					System.out.println("Tipo do contrato........: Contrato assalariado");
				} else if (i instanceof ContratoComissionado) {
					System.out.println("Tipo do contrato........: Contrato comissionado");
				} else if (i instanceof ContratoHorista) {
					System.out.println("Tipo do contrato........: Contrato horista");
				}
				
				System.out.println("Matrícula do colaborador: " +i.getColaborador().getMatricula());
				System.out.println("Nome do colaborador.....: " +i.getColaborador().getNome());
				System.out.println("CPF do colaborador......: " +i.getColaborador().getCpf());
				
				if (i.getColaborador().isSituacao() == true) {
					System.out.println("Situação do colaborador.: ativo");
				} else {
					System.out.println("Situação do colaborador.: inativo");
				}
				
				validacao = true;
				break;
			}
		}
		
		if (validacao == false) {
			System.out.println("Contrato não registrado.");
		}
		
	} // Final do método consultarContrato
	
	public static void encerrarContrato() throws ParseException{
		
		Date hoje = new Date();
		String hojeFormatado = formato.format(hoje);
		Date dataHoje = formato.parse(hojeFormatado);
		
		System.out.print("Digite o id do contrato para encerramento: ");
		int cod = entrada.nextInt();
		
		// Limpar o Buffer:
		entrada.nextLine();
		
		boolean validacao = false;
		boolean validacaoData = false;
		Date dataEncerrar;
		
		for (Contrato i: listaContratos) {
			if (cod == i.getId() && i.isAtivo() == true) {
				
				do {
					
					System.out.print("Digite a data de encerramento do contrato: ");
					dataEncerrar = formato.parse(entrada.nextLine());
					
					if (dataEncerrar.before(dataHoje) == true) {
						i.setDataEncerramento(dataEncerrar);
						i.encerrarContrato();
						i.getColaborador().desativar();
						validacaoData = true;
						validacao = true;
					} else {
						System.out.println("Digite uma data anterior a data atual.");
					}
					
				} while (validacaoData == false);
				
				System.out.println("Contrato encerrado com sucesso.");
			
			} else if (cod == i.getId() && i.isAtivo() == false) {
				validacao = true;
				System.out.println("Contrato já encerrado.");
			}
			
		}
			
		if (validacao == false) {
			System.out.println("Contrato não registrado.");
		}
				
	} // Final do método encerrarContrato
	
	public static void listarColaboradoresAtivos() throws ParseException{
	
		System.out.println("*** Listagem de Colaboradores Ativos ***");
		
		boolean validacao = false;
		
		for (Colaborador i: listaColaboradores) {
			if (i.isSituacao() == true) {
				System.out.println("Matrícula: " +i.getMatricula());
				System.out.println("Nome.....: " +i.getNome());
				System.out.println("CPF......: " +i.getCpf());
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - ");
				validacao = true;
			}
		}
		
		if (validacao == false) {
			System.out.println("Não há colaborador ativo.");
		}
	
	} // Final do método listaColaboradoresAtivos
	
	public static void consultarContratoColaborador() throws ParseException{
	
		String opcao;
		boolean validacao = false;
		
		System.out.println("Digite como deseja consultar o contrato:");
		System.out.println("1) Pela Matrícula");
		System.out.println("2) Pelo CPF");
		System.out.println("--------------------------------------------------");
		System.out.print("Digite a opção desejada: ");
		opcao = entrada.next();
		System.out.println("--------------------------------------------------");
		
		// Limpar o Buffer:
		entrada.nextLine();
		
		if (opcao.equals("1")) {
			
			System.out.print("Digite a matrícula do colaborador: ");
			String matricula = entrada.next();
			
			System.out.println("*** Informações do Colaborador ***");
			
			for (Colaborador i: listaColaboradores) {
				if (matricula.equalsIgnoreCase(i.getMatricula())) {
					System.out.println("Matrícula...............: " +i.getMatricula());
					System.out.println("Nome....................: " +i.getNome());
					System.out.println("CPF.....................: " +i.getCpf());
					
					if (i.isSituacao() == true) {
						System.out.println("Situação do colaborador.: ativo");
					} else {
						System.out.println("Situação do colaborador.: inativo");
					}
					
					System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - ");
					
					System.out.println("*** Informações dos Contratos do Colaborador ***");
					
					for (Contrato j: listaContratos) {
						if (matricula.equalsIgnoreCase(j.getColaborador().getMatricula())) {
							System.out.println("Id do contrato..........: " +j.getId());
							
							if (j instanceof ContratoAssalariado) {
								System.out.println("Tipo do contrato........: Contrato assalariado");
							} else if (j instanceof ContratoComissionado) {
								System.out.println("Tipo do contrato........: Contrato comissionado");
							} else if (j instanceof ContratoHorista) {
								System.out.println("Tipo do contrato........: Contrato horista");
							}
							
							String dataInicio = formato.format(j.getDataInicio());
							System.out.println("Data de início..........: " +dataInicio);
							
							if (j.getDataEncerramento() == null) {
								System.out.println("Data de encerramento....: N/A");
							} else {
								String dataEncerramento = formato.format(j.getDataEncerramento());
								System.out.println("Data de encerramento....: " +dataEncerramento);
							}
							
							if (j.isAtivo() == true) {
								System.out.println("Situação do contrato....: ativo");
							} else {
								System.out.println("Situação do contrato....: inativo");
							}
							
							validacao = true;
							System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - ");
						}
					}
				}
			}
			
			if (validacao == false) {
				System.out.println("Colaborador não inserido.");
			}
			
		}
		
		if (opcao.equals("2")) {
			
			System.out.print("Digite o CPF do colaborador: ");
			String cpf = entrada.next();
			
			System.out.println("*** Informações do Colaborador ***");
			
			for (Colaborador i: listaColaboradores) {
				if (cpf.equalsIgnoreCase(i.getCpf())) {
					System.out.println("Matrícula...............: " +i.getMatricula());
					System.out.println("Nome....................: " +i.getNome());
					System.out.println("CPF.....................: " +i.getCpf());
					
					if (i.isSituacao() == true) {
						System.out.println("Situação do colaborador.: ativo");
					} else {
						System.out.println("Situação do colaborador.: inativo");
					}
					
					System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - ");
					
					System.out.println("*** Informações dos Contratos do Colaborador ***");
					
					for (Contrato j: listaContratos) {
						if (cpf.equalsIgnoreCase(j.getColaborador().getCpf())) {
							System.out.println("Id do contrato..........: " +j.getId());
							
							if (j instanceof ContratoAssalariado) {
								System.out.println("Tipo do contrato........: Contrato assalariado");
							} else if (j instanceof ContratoComissionado) {
								System.out.println("Tipo do contrato........: Contrato comissionado");
							} else if (j instanceof ContratoHorista) {
								System.out.println("Tipo do contrato........: Contrato horista");
							}
							
							String dataInicio = formato.format(j.getDataInicio());
							System.out.println("Data de início..........: " +dataInicio);
							
							if (j.getDataEncerramento() == null) {
								System.out.println("Data de encerramento....: N/A");
							} else {
								String dataEncerramento = formato.format(j.getDataEncerramento());
								System.out.println("Data de encerramento....: " +dataEncerramento);
							}
							
							if (j.isAtivo() == true) {
								System.out.println("Situação do contrato....: ativo");
							} else {
								System.out.println("Situação do contrato....: inativo");
							}
							
							validacao = true;
							System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - ");
						}
					}
				}
			}
			
			if (validacao == false) {
				System.out.println("Colaborador não inserido.");
			}
			
		}
		
	} // Final do método consultarContratoColaborador
	
	public static void lancarVendasComissionadas() throws ParseException{
		
		VendaComissionada venda = new VendaComissionada();
		
		System.out.print("Digite o id do contrato para lançar as vendas: ");
		int cod = entrada.nextInt();
		
		boolean validacao = false;
		
		for (Contrato i: listaContratos) {
			if (cod == i.getId()) {
				if (i.isAtivo() == true) {
					if (i instanceof ContratoComissionado) {
						System.out.print("Digite o id da venda: ");
						venda.setId(entrada.nextInt());
						System.out.print("Digite o mês da venda: ");
						venda.setMes(entrada.nextInt());
						System.out.print("Digite o ano da venda: ");
						venda.setAno(entrada.nextInt());
						System.out.print("Digite o valor total da venda: ");
						venda.setValor(entrada.nextFloat());
						
						venda.setContrComissionado(((ContratoComissionado)i));
						
						listaVendas.add(venda);
						
						System.out.println("Venda lançada com sucesso.");
						
						validacao = true;
					} else {
						System.out.println("Contrato não é do tipo comissionado.");
						validacao = true;
					}
				} else {
					System.out.println("Contrato não está ativo.");
					validacao = true;
				}
			}
		}
		
		if (validacao == false) {
			System.out.println("Contrato não registrado.");
		}
		
	} // Final do método lancarVendasComissionadas
	
	public static void emitirFolhaPagamanto() throws ParseException{
		
		System.out.print("Digite o mês da folha de pagamento: ");
		int mes = entrada.nextInt();
		System.out.print("Digite o ano da folha de pagamento: ");
		int ano = entrada.nextInt();
		
		System.out.println("*** Folha de Pagamento ***");
		
		boolean contratoAtivo = false;
		
		for (Contrato i: listaContratos) {
			if (i.isAtivo() == true) {
				System.out.println("Id do contrato..........: " +i.getId());
				
				if (i instanceof ContratoAssalariado) {
					System.out.println("Tipo do contrato........: Contrato assalariado");
				} else if (i instanceof ContratoComissionado) {
					System.out.println("Tipo do contrato........: Contrato comissionado");
				} else if (i instanceof ContratoHorista) {
					System.out.println("Tipo do contrato........: Contrato horista");
				}
						
				System.out.println("Matrícula...............: " +i.getColaborador().getMatricula());
				System.out.println("Nome....................: " +i.getColaborador().getNome());
						
				if (i instanceof ContratoAssalariado) {
					System.out.printf("Salário.................: %.2f", ((ContratoAssalariado)i).calcVencimento());
				} else if (i instanceof ContratoComissionado) {
					
					boolean validacao = false;
					
					for (VendaComissionada j: listaVendas) {
						if (i.getId() == j.getContrComissionado().getId()) {
							if (mes == j.getMes() && ano == j.getAno()) {
								System.out.printf("Salário.................: %.2f", ((ContratoComissionado)i).calcVencimento(j.getValor()));
								validacao = true;
								break;
							}
						}	
					}
					
					if (validacao == false) {
						System.out.printf("Salário.................: Nenhuma venda lançada neste mês");
					}
					
				} else if (i instanceof ContratoHorista) {
					System.out.printf("Salário.................: %.2f", ((ContratoHorista)i).calcVencimento());
				}
						
				System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - ");
				
				contratoAtivo = true;
			}
		}
		
		if (contratoAtivo == false) {
			System.out.println("Não existem contratos ativos para emissão de folha de pagamento.");
		}
		
	} // Final do método emitirFolhaPagamento
	

} // Final do código
