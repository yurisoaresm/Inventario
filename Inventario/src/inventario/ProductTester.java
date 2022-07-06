/**
 * Declaração dos pacotes e bibliotecas.
 */
package inventario;

import java.util.Scanner;
/**
 * @author Yuri Soares
 * Classe Principal (Driver). Contém todos os métodos para execução do programa de inventário.
 */
public class ProductTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		byte tempNumber;	// Declaração de variáveis temporárias para cada atributo da classe Produto
		String tempName;
		short tempQty;
		double tempPrice;
		int maxSize = -1;        // Número de produtos que o usuário queira adicionar
		
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
		
		// Entrada e processamento dos dados
		if (maxSize == 0)
			System.out.println("Não há produtos");
		else {
			Product[] produtos = new Product[maxSize];
			for (int i = 0; i < maxSize; i++) {
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
			
			// Exibindo informações (saída de dados) de cada produto com loop for-each
			for (Product myProduct : produtos) {
				System.out.println(myProduct.toString());
				System.out.println("--------");
			}
		}
		
	} // fim do método principal

} // fim da classe Driver
