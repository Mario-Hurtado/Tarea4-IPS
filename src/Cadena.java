import java.util.*;

/*
 * Este c�digo se basa en c�digo desarrollado por:
 * https://www.geeksforgeeks.org/implementation-of-blockchain-in-java/
 * Modificado por: Mario Hurtado (201813888) y Nicol�s Rodr�guez (201822980)
 */

public class Cadena {
	// ArrayList to store the blocks
	public static ArrayList<Bloque> blockchain = new ArrayList<Bloque>();
	public static int dificultad = 2;
	// Java implementation to check
	// validity of the blockchain
	// Function to check
	// validity of the blockchain
	public static Boolean isChainValid()
	{
		Bloque currentBlock;
		Bloque previousBlock;
		// Iterating through
		// all the blocks
		for (int i = 1; i < blockchain.size(); i++) {
			// Storing the current block
			// and the previous block
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i - 1);
			// Revisar si el hash almacenado en el bloque es correcto
			if (!currentBlock.darHash().equals(currentBlock.calcularHash())) {
				System.out.println("El hash actual no es correcto.");
				return false;
			}
			// Revisar si el hash que aparece como previo es igual
			//al hash almacenado en el bloque previo
			if (!previousBlock.darHash().equals(currentBlock.darHashPrevio())) {
				System.out.println("El hash previo no es correcto.");
				return false;
			}
		}
		// If all the hashes are equal
		// to the calculated hashes,
		// then the blockchain is valid
		return true;
	}
	public static void printChain()
	{
		for (int i = 0; i < blockchain.size(); i++) {
			Bloque currentBlock = blockchain.get(i);
			currentBlock.printBlock();
			System.out.println("//////////////////////////////////////////");
		}
	}
	public static void addBlock(Bloque newBlock) {
		newBlock.minarBloque(dificultad);
		blockchain.add(newBlock);
	}
	public static void main(String[] args)
	{
		String cadena1 = "";
		String cadena2 = "Bloque Génesis";
		String cadena3 = "";
		String cadena4 = "";
		String cadena5 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In quis augue et nisi sodales dictum. Curabitur egestas aliquet nunc, ut sagittis nisl rutrum scelerisque. Cras eget vehicula orci, a gravida dui. Fusce vitae mauris quis elit condimentum vestibulum. Sed vehicula libero eu augue vulputate accumsan. Sed efficitur, magna eu lacinia vehicula, ipsum odio viverra quam, quis vehicula sapien ligula nec ex. Nulla sit amet tortor tristique, accumsan leo quis, rutrum ipsum. Phasellus luctus ligula et lectus euismod viverra. Donec dignissim nisl interdum massa vulputate ullamcorper. Ut congue mattis ante sit amet tristique. Etiam viverra quam accumsan dui tincidunt porta.";

		System.out.println("Creando el bloque Genesis... ");
		Bloque genesis = new Bloque(0, cadena5, "00");
		addBlock(genesis);

		System.out.println("--------------------------------------------");

		/* System.out.println("Adicionando el primer bloque ");
		Bloque bloque1 = new Bloque(1,"Primer Bloque", genesis.darHash());
		addBlock(bloque1);

		System.out.println("--------------------------------------------");

		System.out.println("Adicionando el segundo bloque ");
		Bloque bloque2 = new Bloque(2, "Segundo Bloque", bloque1.darHash());
		addBlock(bloque2);

		System.out.println("--------------------------------------------");

		System.out.println("Adicionando el tercer bloque ");
		Bloque bloque3 = new Bloque(3, "Tercer Bloque", bloque2.darHash());
		addBlock(bloque3);

		System.out.println("--------------------------------------------");

		System.out.println("\n Imprimiendo la cadena resultante: ");
		printChain(); */

		System.out.println("verificando validez de la cadena: " + isChainValid());
	}
}