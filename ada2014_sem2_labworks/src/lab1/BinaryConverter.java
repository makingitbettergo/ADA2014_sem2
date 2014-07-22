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
			result = temp % 2 + result;// 3 steps for modular + %2 lookup +
										// reassignment
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
		int[] decimals = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
				4096, 8192, 16384, 32768, 65536, 131072, 262144 };
		BinaryConverter bc = new BinaryConverter(decimals);
		bc.convertToBinary();
	}
}
