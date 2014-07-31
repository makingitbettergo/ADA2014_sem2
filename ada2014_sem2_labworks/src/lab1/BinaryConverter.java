package lab1;

/**
 * A decimal-binary converter
 * 
 * @author go-mk03
 * @version 22-07-14
 *
 */
public class BinaryConverter {

	public int[] decimals;
	public String[] binarys;

	/**
	 * construct an instance with predefined decimal array
	 * 
	 * @param decimals
	 */
	public BinaryConverter(int[] decimals) {
		this.decimals = decimals;
		binarys = new String[decimals.length];
	}

	/**
	 * Convert to binary and output the result
	 * 
	 * @param num
	 * @return
	 */
	public void toBinary(int num) {
		String result = "";
		int temp = num;
		int counter = 0;
		while (temp > 0) {
			result = temp % 2 + result;// 3 steps for modular + creating new
										// string + reassignment
			temp /= 2; // 2 steps for division + reassignment
			counter += 5; // therefore counter +5 each loop
		}
		System.out.println("case: " + num + " has " + counter
				+ " operations, result: " + result);
	}

	/**
	 * a wrapper method for converting an array of integers
	 */
	public void convertToBinary() {
		for (int i = 0; i < decimals.length; i++) {
			toBinary(decimals[i]);
		}
	}

	public static void main(String[] args) {
		// n
		int[] decimals = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
				4096, 8192, 16384, 32768, 65536, 131072, 262144 };
		BinaryConverter bc = new BinaryConverter(decimals);
		bc.convertToBinary();
		// n * 3
		int[] decimalsMultiple3 = new int[decimals.length];
		for (int i = 0; i < decimals.length; i++) {
			decimalsMultiple3[i] = decimals[i] * 3;
		}
		BinaryConverter bc1 = new BinaryConverter(decimalsMultiple3);
		bc1.convertToBinary();
		// n * 0.3
		int[] decimalsMultipleDot3 = new int[decimals.length];
		for (int i = 0; i < decimals.length; i++) {
			decimalsMultipleDot3[i] = (int) (decimals[i] * 0.3);
		}
		BinaryConverter bc2 = new BinaryConverter(decimalsMultipleDot3);
		bc2.convertToBinary();
		BinaryConverter bc3 = new BinaryConverter(new int[] { 15 });
		bc3.convertToBinary();
	}
}
