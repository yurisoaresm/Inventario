/**
 * 
 */
package inventario;

/**
 * @author Yuri Soares
 * 
 *	Classe do projeto Inventário. Esta classe armazena informações do objeto produto.
 *  Ela representa cada produto gerenciado no inventário.
 */
public class Product {
	// Declarações de campo de instância
	protected byte numId;
	protected String nome;
	protected short numEstoque;
	protected double preco;
	protected boolean ativo = true;
	
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
	
	// Método para adicionar produtos no estoque
	public void addToInventory(int numAdd) {
		if (isAtivo()) 
			numEstoque += numAdd;
		else 
			System.out.println("Esta linha foi descontinuada.");
		
	}
	
	// Método para deduzir ("deduct": subtrair, diminuir) produtos no estoque
	public void deductFromInventory(int numDeduct) {
		numEstoque -= numDeduct;
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
	
	public boolean isAtivo() {
		return ativo;
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
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	// Outros métodos
	public double getValorInventario() {
		return preco * numEstoque;
	}
	
	@Override
	public String toString() {
		String s1 =
		    "Número do Item       : "+ getNumId()
		+ "\nNome                 : "+ getNome()
		+ "\nQuantidade em estoque: "+ getNumEstoque()
		+ "\nPreço                : R$ "+ getPreco()
		+ "\nValor do estoque     : R$ "+ getValorInventario()
		+ "\nStatus do produto    : "+ (isAtivo() ? "Ativo" : "Descontinuado");
		return s1;
	}
} // fim da classe Product
