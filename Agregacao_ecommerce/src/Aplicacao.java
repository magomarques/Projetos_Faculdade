import java.util.Scanner;

public class Aplicacao {
	
	static Scanner entrada = new Scanner(System.in);
	
	static int contador = 1;
	
	static Carrinho c;

	public static void main(String[] args) {
		
		String opcao = "";
		boolean repeticao = true;
		
		do {
		
			System.out.println("================= MENU DE ACESSO =================");
			System.out.println("1) Inserir produto no carrinho");
			System.out.println("2) Confirmar uma venda");
			System.out.println("3) Exibir uma venda");
			System.out.println("0) Finalizar");
			System.out.println("--------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			opcao = entrada.next();
			System.out.println("--------------------------------------------------");
			
			// Limpar o Buffer:
			entrada.nextLine();
				
			switch (opcao){
				
				case "1":
					inserirProdutoCarrinho();
				break;
					
				case "2":
					confirmarVenda();
				break;
				
				case "3":
					exibirVenda();
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

	} // FIM DO MÉTODO MAIN

	// SUB-ROTINAS:
	
	public static void inserirProdutoCarrinho() {
		
		Produto p = new Produto();
		
		if (contador == 1) {
			c = new Carrinho();
		}
		
		if (c.getStatus().equalsIgnoreCase("False")) {
		
			if (contador <= c.getItens().length) {
		
				System.out.print("Digite o código do produto: ");
				p.setCodigo(entrada.nextInt());
		
				System.out.print("Digite a descrição do produto: ");
				p.setDescricao(entrada.next());
		
				System.out.print("Digite o preço de venda do produto: ");
				p.setPrecoVenda(entrada.nextFloat());
		
				System.out.print("Digite a alíquota do ICMS do produto: ");
				p.setAliquotaICMS(entrada.nextFloat());
		
				contador++;
		
				if (p.isVendido() == false) {
					c.insereItem(p);
					System.out.println("Produto inserido no carrinho com sucesso.");
				} else {
					System.out.println("Produto já vendido.");
				}
		
			} else {
				System.out.println("Carrinho lotado. Não é possível inserir o produto.");
			}
		
		} else {
			System.out.println("Venda já confirmada. Não é possível inserir o produto.");
		}
		
	}
	
	public static void confirmarVenda() {
		
		if (c.getStatus().equalsIgnoreCase("false")) {
			c.confirmarCompra();
			System.out.println("Venda confirmada com sucesso.");
		} else {
			System.out.println("Venda já confirmada.");
			
		}
		
	}
	
	public static void exibirVenda() {
		
		System.out.println("***** INFORMAÇÕES DA VENDA *****");
		System.out.println("ID da venda..............: " + c.getId());
		System.out.println("Status da venda..........: " + c.getStatus());
		System.out.printf("Valor do ICMS da venda...: %.2f", c.getValorICMS());
		System.out.printf("\nValor total da venda.....: %.2f", c.getValorVenda());
		
		
		System.out.println("\n****** PRODUTOS DA VENDA ******");
		
		for (Produto i: c.getItens()) {
		
			if (i != null && c.getStatus().equalsIgnoreCase("Confirmada")) {
				System.out.println("Código do produto........: " + i.getCodigo());
				System.out.println("Descrição do produto.....: " + i.getDescricao());
				System.out.printf("Preço de venda do produto: %.2f", i.getPrecoVenda());
				System.out.printf("\nValor do ICMS do produto.: %.2f", i.calcularICMS());
				System.out.println("\n-------------------------------");
			}
		}
		
		if (c.getStatus().equalsIgnoreCase("False")) {
			System.out.println("Venda não confirmada.");
			System.out.println("-------------------------------");
		}
		
	}
	
}
