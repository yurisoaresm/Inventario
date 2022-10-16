/**
 * 
 */
package inventario;

/**
 * @author Yuri Soares
 *
 */
public class Cd extends Product {
	private String artista;
	private int numMusicas;
	private String selo;
	
	// Métodos construtores
	public Cd() {
		
	}
	
	public Cd(byte numId, String nome, short numEstoque, double preco, String artista, int numMusicas, String selo) {
		super(numId, nome, numEstoque, preco);
		this.artista = artista;
		this.numMusicas = numMusicas;
		this.selo = selo;
	}
	
	// Métodos acessores e modificadores
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public int getNumMusicas() {
		return numMusicas;
	}
	
	public void setNumMusicas(int numMusicas) {
		this.numMusicas = numMusicas;
	}
	
	public String getSelo() {
		return selo;
	}
	
	public void setSelo(String selo) {
		this.selo = selo;
	}
	
	@Override
	public String toString() {
		String s1 =
		    "Número do Item          : "+ getNumId()
		+ "\nNome                    : "+ getNome()
		+ "\nArtista	             : "+ getArtista()
		+ "\nMúsicas do Álbum        : "+ getNumMusicas()
		+ "\nSelo de gravação        : "+ getSelo()
		+ "\nQuantidade em estoque   : "+ getNumEstoque()
		+ "\nPreço                   : R$ "+ getPreco()
		+ "\nValor do estoque        : R$ "+ getValorInventario()
		+ "\nStatus do produto       : "+ (isAtivo() ? "Ativo" : "Descontinuado");
		return s1;
	}
	
}
