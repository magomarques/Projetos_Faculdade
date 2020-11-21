import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Aplicacao {

	static Scanner entrada = new Scanner(System.in);
	
	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) throws ParseException {
		
		// Criar 02 imóveis:
		Imovel imovel1 = new Imovel(111, "Rua nova  um , 111", 'C', 0);
		Imovel imovel2 = new Imovel(222, "Rua nova dois, 222", 'R', 0);
		
		// Criar lista de imóveis:
		List<Imovel> listaImoveis = new ArrayList<Imovel>();
		
		// Adicionar os dois imóveis a lista de imóveis:
		listaImoveis.add(imovel1);
		listaImoveis.add(imovel2);
		
		// Criar lista de leituras:
		List<Leitura> listaLeituras = new ArrayList<Leitura>();
		
		// Construção do menu:
		
		String opcao = "";
		boolean verificar = true;
		boolean validar;
		
		do {
				
			// Registrar/Auditar leituras:
			System.out.println("================= MENU DE ACESSO =================");
			System.out.println("1) Registrar Leitura");
			System.out.println("2) Auditar Leitura");
			System.out.println("0) Finalizar");
			System.out.println("--------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			opcao = entrada.next();
			System.out.println("--------------------------------------------------");
			
			switch (opcao){
				
			case "1":
				validar = false;
				// Registar Leitura:
				System.out.print("Digite o ID do imóvel para registrar leitura: ");
				int id = entrada.nextInt();
				
				// Limpar o Buffer:
				entrada.nextLine();
				
				for (Imovel i: listaImoveis) {
					
					if (id == i.getId()) {
						
						System.out.print("Digite a data da leitura.: ");
						Date data = formato.parse(entrada.nextLine());
						
						System.out.print("Digite o valor da leitura: ");
						int valorLeitura = entrada.nextInt();
						
						// Calcular o consumo:
						i.calcularConsumo(valorLeitura);
						
						// Valor da conta do imóvel:
						i.calcularConta();
							
						// Atualizar a última leitura do imóvel:
						i.atualizarLeitura(valorLeitura);
						
						// Criar uma leitura:
						Leitura leitura = new Leitura(i, valorLeitura, data);
						
						// Adiconar a leitura a lista de leituras:
						listaLeituras.add(leitura);
						
						validar = true;
						break;
					}
				}
				
				if (validar == false) {
					System.out.println("--------------------------------------------------");
					System.out.println("IMÓVEL NÃO ENCONTRADO");
				}
				System.out.println("--------------------------------------------------");	
			break;
					
			case "2":
				validar = false;
				// Auditar Leitura:
				System.out.print("Digite o ID do imóvel para consulta: ");
				id = entrada.nextInt();
				
				for (Imovel i: listaImoveis) {
					if (id == i.getId()) {
						System.out.println("--------------------------------------------------");
						System.out.println("*** DADOS DO IMÓVEL ***");
						System.out.println("Endereço do imóvel: " + i.getEndereco());
						System.out.println("Tipo do imóvel....: " + i.getTipo());
						System.out.println("--------------------------------------------------");
						validar = true;
						break;
					}
				}
				
				for (Leitura j: listaLeituras) {
					if (id == j.getImovel().getId()) {
						System.out.println("ID da leitura.....: " + j.getId());
						System.out.println("Última leitura....: " + j.getImovel().getUltimaLeitura());	
						System.out.println("Consumo do imóvel.: " + j.getImovel().getConsumo());
						System.out.printf("Conta do imóvel...: R$ %.2f\n", j.getImovel().getValorConta());
						System.out.println("--------------------------------------------------");
					}
				}
								
				if (validar == false) {
					System.out.println("--------------------------------------------------");
					System.out.println("IMÓVEL NÃO ENCONTRADO");
				}
				System.out.println("--------------------------------------------------");
				break; 
				
			case "0":
				// Finalização da execução do programa:
				System.out.println("EXECUÇÃO FINALIZADA!");
				verificar = false;
				break;
					
			default:
				// Tratamento para opções inválidas digitadas:
				System.out.println("OPÇÃO INVÁLIDA! DIGITE UMA OPÇÃO VÁLIDA!");
				System.out.println("--------------------------------------------------");
				break;
			
			}
				
		} while (verificar == true);
		
	}

}
