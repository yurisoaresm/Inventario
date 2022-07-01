/**
 * 
 */
package inventario;

/**
 * @author Yuri
 *	Classe do projeto Inventário. Esta classe armazena informações do objeto produto.
 *  Ela representa cada produto gerenciado no inventário.
 */
public class Product {
	// Declarações de campo de instância
	private byte numId;
	private String nome;
	private short numEstoque;
	private double preco;
	
	// Construtores
	// Construtor padrão para instanciar um produto com valores padrões.
	public Product() {
		
	}
	// Construtor sobrecarregado para instanciar um produto com valores passados na classe Driver
	public Product(byte numId, String nome, short numEstoque, double preco) {
		this.numId = numId;
		this.nome = nome;
		this.numEstoque = numEstoque;
		this.preco = preco;
	}
	
	// Métodos acessores: retornam o valor de campo (variável) do objeto
	public byte getNumId() {
		return numId;
	}
	
	public String getNome() {
		return nome;
	}
	
	public short getNumEstoque() {
		return numEstoque;
	}
	
	public double getPreco() {
		return preco;
	}
	
	// Métodos modificadores: alteram o valor de campo do objeto
	public void setNumId(byte numId) {
		this.numId = numId;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNumEstoque(short numEstoque) {
		this.numEstoque = numEstoque;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		String s1 =
		    "Número do Item       : "+ getNumId()
		+ "\nNome                 : "+ getNome()
		+ "\nQuantidade em estoque: "+ getNumEstoque()
		+ "\nPreço                : "+ getPreco();
		return s1;
	}
} // fim da classe Product
