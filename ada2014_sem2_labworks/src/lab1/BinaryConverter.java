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

	public void convertToBinary() {
		for (int i = 0; i < decimals.length; i++) {
			toBinary(decimals[i]);
		}
	}

	public static void main(String[] args) {
		int[] decimals = { 12, 3, 128, 15, 1, 195742 };
		BinaryConverter bc = new BinaryConverter(decimals);
		bc.convertToBinary();
	}
}
