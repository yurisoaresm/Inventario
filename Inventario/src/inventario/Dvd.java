/**
 * 
 */
package inventario;

/**
 * @author Yuri Soares
 *
 */
public class Dvd extends Product {
	private int duracaoMin;
	private String classifEtaria;
	private String estudio;
	
	// Métodos construtores
	public Dvd() {
		
	}	
	
	public Dvd(byte numId, String nome, short numEstoque, double preco, int duracaoMin, String classEtaria, String estudio) {
		super(numId, nome, numEstoque, preco);
		this.duracaoMin = duracaoMin;
		this.classifEtaria = classEtaria;
		this.estudio = estudio;
	}	
	
	// Métodos acessores e modificadores das variáveis de instância de DVD
	public int getDuracaoMin() {
		return duracaoMin;
	}
	
	public void setDuracaoMin(int duracaoMin) {
		this.duracaoMin = duracaoMin;
	}
	
	public String getClassifEtaria() {
		return classifEtaria;
	}
	
	public void setClassifEtaria(String classifEtaria) {
		this.classifEtaria = classifEtaria;
	}
	
	public String getEstudio() {
		return estudio;
	}
	
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	// Outros métodos
	
	/**
	 * Este método calcula o valor de inventário para os produtos do tipo DVD e adiciona uma taxa
	 * de reposição de estoque de 5%. 
	 */
	@Override
	public double getValorInventario() {
		return super.getValorInventario() * 1.05;
	}
	
	@Override
	public String toString() {
		String s1 =
		    "Número do Item          : "+ getNumId()
		+ "\nNome                    : "+ getNome()
		+ "\nDuração do Filme	     : "+ getDuracaoMin()
		+ "\nClassificação Etária    : "+ getClassifEtaria()
		+ "\nEstúdio Cinematográfico : "+ getEstudio()
		+ "\nQuantidade em estoque   : "+ getNumEstoque()
		+ "\nPreço                   : R$ "+ getPreco()
		+ "\nValor do estoque        : R$ "+ getValorInventario()
		+ "\nStatus do produto       : "+ (isAtivo() ? "Ativo" : "Descontinuado");
		return s1;
	}
}

