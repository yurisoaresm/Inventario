/**
 * 
 */
package inventario;

/**
 * @author yuri
 * Classe Principal (Driver). Contém todos os métodos para execução do programa de inventário.
 */
public class ProductTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product((byte)3, "Clássicos da Literatura", (short)40, 19.90);
		Product p4 = new Product((byte)4, "Grande Hits dos anos 80 e 90", (short)70, 9.97);
		Product p5 = new Product((byte)5, "Chapéus", (short)30, 24.99);
		Product p6 = new Product((byte)6, "Jogos PS2", (short)100, 10.00);
		
		System.out.println(p1);
		System.out.println("------------");
		System.out.println(p2);
		System.out.println("------------");
		System.out.println(p3);
		System.out.println("------------");
		System.out.println(p4);
		System.out.println("------------");
		System.out.println(p5);
		System.out.println("------------");
		System.out.println(p6);
	}

}
