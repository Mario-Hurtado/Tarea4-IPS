public class Bloque {
	/**
	 * Completar: Declarar los atributos de la clase (todos deben ser privados).
	 * Los atributos faltantes son: hash (string), hashprevio(string), datos(string) y
	 * nonce (int)
	 */
	private int id;
	private long timeStamp;
	private String hash;
	private String hashprevio;
	private String datos;
	private int nonce;

	/**
	 * Datos de entrada: id del bloque, datos (tipo String), hash previo (tipo String)
	 * El m�todo inicializa todos los atributos del bloque:
	 * - asigna los valores que recibe como entrada (a los atributos apropiados)
	 * - inicializar los dem�s atributos con valores por defecto.
	 */
	public Bloque(int pId, String pDatos, String pHashPrevio) {
		// Completar: escribir el cuerpo del m�todo constructor
		id = pId;
		datos = pDatos;
		hashprevio = pHashPrevio;
		timeStamp = 0;
		hash = "Hash Inicial";
		nonce = 0;
	}

	/**
	 * El m�todo calcula el hash del bloque con base en los datos asignados a los
	 * atributos.
	 * @return: retorna el hash del bloque
	 */
	public String calcularHash() {
		// Completar:
		// extienda la variable dato con los atributos del bloque
		// para calcular el hash sobre todos los datos relevantes:
		// hashprevio, timestamp, datos y nonce.
		String dato = hashprevio + Long.toString(timeStamp) + datos + Integer.toString(nonce);
		String calculatedhash = Cripto.sha256(dato);
		return calculatedhash;
	}
	/**
	 * El m�todo imprime por consola el contenido del bloque.
	 */
	public void printBlock() {
		// Completar:
		// imprima por consola todos los campos del bloque
		System.out.println("==== Bloque " + id + " =====" );
		System.out.println("==== Timestamp: " + timeStamp + " =====" );
		System.out.println("==== Hash: " + hash + " =====" );
		System.out.println("==== Hash Previo: " + hashprevio + " =====" );
		System.out.println("==== Datos: " + datos + " =====" );
		System.out.println("==== Nonce: " + nonce + " =====" );
	}
	/**
	 * El m�todo mina el bloque: busca un hash que cumpla la condici�n definida
	 * @param dificultad: n�mero de ceros que deben aparecer al comienzo del hash
	 */
	public void minarBloque(int dificultad) {
		long initialTime = java.lang.System.currentTimeMillis();
		String tgt = getDificultad(dificultad); //Create a string with difficulty * "0"
		while(!hash.substring(0, dificultad).equals(tgt)) {
			nonce ++;
			hash = calcularHash();
		}
		long finalTime = java.lang.System.currentTimeMillis();
		System.out.println("Bloque minado : " + hash);
		System.out.println("Tiempo de minado: " + (finalTime - initialTime) + " milisegundos");
	}
	//Returns difficulty string target, to compare to hash.
	//e.g. difficulty of 5 will return "00000"
	public String getDificultad(int dificultad) {
		return new String(new char[dificultad]).replace('\0', '0');
	}
	/**
	 * El m�todo retorna el valor del atributo correspondiente
	 * @return: retorna el valor del hash del bloque
	 */
	public String darHash() {
		// completar:
		// retornar el valor del hash del bloque
		return hash;
	}
	/**
	 * El m�todo retorna el valor del atributo correspondiente
	 * @return retorna el valor del hash previo
	 */
	public String darHashPrevio() {
		// completar:
		// retornar el valor del hash previo
		return hashprevio;
	}
}