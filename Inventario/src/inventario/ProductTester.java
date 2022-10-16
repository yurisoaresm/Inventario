/**
 * Declaração dos pacotes e bibliotecas.
 */
package inventario;

import java.util.Scanner;
/**
 * Classe principal que contém todos os métodos para gerenciar o programa de inventário.
 * Esse programa é capaz de criar uma lista de produtos diversos e gerenciá-los, atualizando,
 * modificando ou removendo dados.
 * 
 * @author Yuri Soares
 * 
 */
public class ProductTester {

	/**
	 * Este método inicializa o input do usuário e as variáveis que definirão o tamanho da lista
	 * de produtos que se deseja criar e a escolha das opções do menu.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // Objeto Scanner para input do teclado
		int maxSize, menuChoice;
		
		maxSize = getNumProducts(in);
		if (maxSize == 0) // Exibe a mensagem "não há produtos" se a entrada for 	zero
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
		default: // a única opção fora das escolhas acima é o zero
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
		int stockChoice = -1;
	
		do {
			try {
				System.out.println("1: CD"
						+ "\n2: DVD"
						+ "\nInsira o tipo de produto:");
				stockChoice = in.nextInt();
				if (stockChoice < 1 || stockChoice > 2)
					System.out.println("Somente os números 1 ou 2 são permitidos!\n");
			} catch (Exception e) {
				System.out.println("Tipo incorreto de dado inserido!\n");
				in.nextLine();
			}
		} while (stockChoice < 1 || stockChoice > 2);
		
		if (stockChoice == 1)
			addCDToInventory(produtos, in);
		else
			addDVDToInventory(produtos, in);

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
	
	/**
	 * Este método insere as características de cada produto que será adicionado ao inventário
	 * por meio das entradas (inputs) do usuário e as armazena na lista de produtos.
	 * 
	 * @param produtos Primeiro parâmetro para o método addToInvetory. É do tipo Product e 
	 * define a lista com os produtos que serão definidos.	
	 * @param in Segundo parâmetro para o método addToInvetory. É do tipo Scanner e recebe as
	 * entradas do usuário.	
	 */
	public static void addToInventory (Product[] produtos, Scanner in) {
		// Declaração de variáveis temporárias para cada atributo da classe Produto
		byte tempNumber;	
		String tempName;
		short tempQty;
		double tempPrice;
		
		for (int i = 0; i < produtos.length; i++) {
			in.nextLine(); // Limpa o buffer de entrada antes de solicitar novos valores.
			
			System.out.println("Digite o nome do produto (tipo de produto): ");
			tempName = in.nextLine();
			System.out.println("Digite a quantidade em estoque do produto: ");
			tempQty = in.nextShort();
			System.out.println("Digite o preço para este produto: ");
			tempPrice = in.nextDouble();
			System.out.println("Digite o número do item: ");
			tempNumber = in.nextByte();
			
			produtos[i] = new Product(tempNumber, tempName, tempQty, tempPrice);
		}
	}
	
	/**
	 * Este método insere as características de cada produto do tipo CD que será adicionado ao 
	 * inventário por meio das entradas (inputs) do usuário e as armazena na lista de produtos.
	 * Os objetos instanciados são da classe Cd.
	 * 
	 * @param produtos Primeiro parâmetro para o método addCDToInventory. É do tipo Product e 
	 * define a lista com os produtos que serão definidos.	
	 * @param in Segundo parâmetro para o método addCDToInventory. É do tipo Scanner e recebe as
	 * entradas do usuário.	
	 */
	public static void addCDToInventory (Product[] produtos, Scanner in) {
		// Declaração de variáveis temporárias para cada atributo da classe Produto
		byte tempNumber;	
		String tempName;
		short tempQty;
		double tempPrice;
		String tempArtista;
		int tempNumMusicas;
		String tempSelo;
		
		for (int i = 0; i < produtos.length; i++) {
			in.nextLine(); // Limpa o buffer de entrada antes de solicitar valores
			
			System.out.println("Insira o nome do CD: ");
			tempName = in.nextLine();
			System.out.println("Insira o nome do artista: ");
			tempArtista = in.nextLine();
			System.out.println("Insira o nome do selo de gravação: ");
			tempSelo = in.nextLine();
			System.out.println("Insira o número de músicas: ");
			tempNumMusicas = in.nextInt();
			System.out.println("Digite a quantidade em estoque do produto: ");
			tempQty = in.nextShort();
			System.out.println("Digite o preço para este produto: ");
			tempPrice = in.nextDouble();
			System.out.println("Digite o número do item: ");
			tempNumber = in.nextByte();
			
			produtos[i] = new Cd(tempNumber, tempName, tempQty, tempPrice, tempArtista, tempNumMusicas, tempSelo);
		}
	}
	
	/**
	 * Este método insere as características de cada produto do tipo DVD que será adicionado ao 
	 * inventário por meio das entradas (inputs) do usuário e as armazena na lista de produtos.
	 * Os objetos instanciados são da classe Dvd.
	 * 
	 * @param produtos Primeiro parâmetro para o método addDVDToInventory. É do tipo Product e 
	 * define a lista com os produtos que serão definidos.	
	 * @param in Segundo parâmetro para o método addDVDToInventory. É do tipo Scanner e recebe as
	 * entradas do usuário.	
	 */
	public static void addDVDToInventory (Product[] produtos, Scanner in) {
		// Declaração de variáveis temporárias para cada atributo da classe Produto
		byte tempNumber;	
		String tempName;
		short tempQty;
		double tempPrice;
		int tempDuracaoMin;
		String tempClassifEtaria;
		String tempEstudio;
		
		for (int i = 0; i < produtos.length; i++) {
			in.nextLine(); // Limpa o buffer de entrada antes de solicitar valores
			
			System.out.println("Insira o nome do CD: ");
			tempName = in.nextLine();
			System.out.println("Insira o nome do estúdio cinematográfico: ");
			tempEstudio = in.nextLine();
			System.out.println("Insira a classificação etária: ");
			tempClassifEtaria = in.nextLine();
			System.out.println("Insira a duração em minutos: ");
			tempDuracaoMin = in.nextInt();
			System.out.println("Digite a quantidade em estoque do produto: ");
			tempQty = in.nextShort();
			System.out.println("Digite o preço para este produto: ");
			tempPrice = in.nextDouble();
			System.out.println("Digite o número do item: ");
			tempNumber = in.nextByte();
			
			produtos[i] = new Dvd(tempNumber, tempName, tempQty, tempPrice, tempDuracaoMin, tempClassifEtaria, tempEstudio);
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
