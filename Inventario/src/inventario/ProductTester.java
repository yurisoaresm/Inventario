/**
 * Declaração dos pacotes e bibliotecas.
 */
package inventario;

import java.util.Scanner;
/**
 * @author Yuri Soares
 * 
 * Classe Principal (Driver). Contém todos os métodos para execução do programa de inventário.
 */
public class ProductTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // Objeto Scanner para input do teclado
		int maxSize, menuChoice;
		
		maxSize = getNumProducts(in);
		if (maxSize == 0)
			System.out.println("Não há produtos");
		else {
			Product[] produtos = new Product[maxSize];
			addToInventory(produtos, in);
			do {
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice, produtos, in);
			} while (menuChoice != 0);
		}
		
		
		
	} // fim do método principal
	

	public static void executeMenuChoice(int menuChoice, Product[] produtos, Scanner in) {
		
		switch (menuChoice) {
		case 1:
			System.out.println("Exibir Lista de Produtos");
			displayInventory(produtos);
			break;
		case 2:
			System.out.println("Adicionar Estoque");
			addInventory(produtos, in);
			break;
		case 3:
			System.out.println("Deduzir Estoque");
			deductInventory(produtos, in);
			break;
		case 4:
			System.out.println("Descontinuar Estoque");
			discontinueInventory(produtos, in);
			break;
		default: // OBSERVAÇÃO: a única opção fora das escolhas acima é o zero
			System.out.println("Programa finalizado.");
		}
	}
	
	// Menu para seleção
	public static int getMenuOption(Scanner in) {
		int opcao = -1;
		
		try {
			do {
				System.out.println("1. Exibir Inventário"
						+ "\n2. Adicionar Estoque" 
						+ "\n3. Deduzir (diminuir) Estoque"
						+ "\n4. Descontinuar Produto"
						+ "\n0. Sair"
						+ "\nInsira uma opção de menu:");
				opcao = in.nextInt();
				
				// Tratamento de erros
				if (opcao < 0 || opcao > 4) {
					System.out.println("Número inválido. Digite um dos números do menu.");
					in.nextLine();
				}		
			} while (opcao < 0 || opcao > 4);
			
		} catch (Exception e) {
			System.out.println("Tipo incorreto de dado inserido!\n");
			in.nextLine();
		} 
		
		return opcao;
	}
	
	// Método para adicionar valores de estoque a cada produto identificado
	public static void addInventory(Product[] produtos, Scanner in) {
		int productChoice;
		int updateValue = -1;
		
		productChoice = getProductNumber(produtos, in);
		
		do {
			try {
				System.out.println("Quantos produtos deseja adicionar?");
				updateValue = in.nextInt();
				if (updateValue < 0)
					System.out.println("O valor não pode ser negativo.\n");
			} catch (Exception e) {
				System.out.println("Tipo incorreto de dado inserido!\n");
				in.nextLine();
			}
		} while (updateValue < 0);
		
		produtos[productChoice].addToInventory(updateValue); 

	}
	
	// Método para deduzir (diminuir) valores de estoque a cada produto identificado
	public static void deductInventory(Product[] produtos, Scanner in) {
		int productChoice;
		int updateValue = -1;
		
		productChoice = getProductNumber(produtos, in);
		
		do {
			try {
				System.out.println("Quantos produtos deseja deduzir (remover)?");
				updateValue = in.nextInt();
				if (updateValue < 0)
					System.out.println("O valor não pode ser negativo.\n");
				else if (updateValue > produtos[productChoice].getNumEstoque())
					System.out.println("Não há essa quantidade do produto em estoque");
			} catch (Exception e) {
				System.out.println("Tipo incorreto de dado inserido!\n");
				in.nextLine();
			}
		} while (updateValue < 0 || updateValue > produtos[productChoice].getNumEstoque());
		
		produtos[productChoice].deductFromInventory(updateValue); 

	}
	
	// Método para descontinuar um estoque
	public static void discontinueInventory(Product[] produtos, Scanner in) {
		int productChoice;
		
		productChoice = getProductNumber(produtos, in);
		produtos[productChoice].setAtivo(false);
			
	}
		
	// Método para selecionar um produto no array
	public static int getProductNumber(Product[] produtos, Scanner in) {
		int productChoice = -1;
		
		for (int i = 0; i < produtos.length; i++) {
			
			System.out.println("Índice: "+ i +" Nome do Produto: "+ produtos[i].getNome());
		}
		
		do {
			try {
				System.out.println("Escolha o índice do produto que deseja atualizar: ");
				productChoice = in.nextInt();
				
				if (productChoice < 0 || productChoice > produtos.length - 1) {
					System.out.println("Índice não encontrado. Digite um número válido.");
					in.nextLine();
				}
			} catch (Exception e) {
				System.out.println("Tipo incorreto de dado inserido!\n");
				in.nextLine();
			}
		} while (productChoice < 0 || productChoice > produtos.length - 1);

		return productChoice;
	}
	
	public static int getNumProducts(Scanner in) {
		int maxSize = -1;
		
		// Tratamento de erros e exceções
			do {
				try {
					System.out.println("Insira o número de produtos que gostaria de adicionar.");
					System.out.println("Insira 0 (zero) se não quiser adicionar produtos:");
					maxSize = in.nextInt();
					if (maxSize < 0)
						System.out.println("Valor incorreto inserido.\n");
				} catch (Exception e) {
					System.out.println("Tipo incorreto de dado inserido!\n");
					in.nextLine();
				}
			} while (maxSize < 0);
		return maxSize;
	}
	
	public static void addToInventory (Product[] produtos, Scanner in) {
		byte tempNumber;	// Declaração de variáveis temporárias para cada atributo da classe Produto
		String tempName;
		short tempQty;
		double tempPrice;
		
		for (int i = 0; i < produtos.length; i++) {
			in.nextLine();
			
			System.out.println("Digite o nome do produto (tipo de produto): ");
			tempName = in.nextLine();
			System.out.println("Digite a quantidade em estoque do produto: ");
			tempQty = in.nextShort();
			System.out.println("Digite o preço: ");
			tempPrice = in.nextDouble();
			System.out.println("Digite o número do item: ");
			tempNumber = in.nextByte();
			
			produtos[i] = new Product(tempNumber, tempName, tempQty, tempPrice);
		}
	}
	
	public static void displayInventory(Product[] produtos) {
	// Exibindo informações (saída de dados) de cada produto com loop for-each
		for (Product myProduct : produtos) {
			System.out.println(myProduct.toString());
			System.out.println("--------");
		}
	}

} // fim da classe Driver
