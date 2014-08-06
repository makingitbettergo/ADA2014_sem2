package lab2;

public class PrimalityTest {

	/**
	 * linear
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPrime1(int num) {
		for (int i = 2; i < i - num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * improved linear
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPrime2(int num) {
		int limit = (int) Math.sqrt(num);
		for (int i = 2; i < limit; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	// public boolean isPrime3(int num)

	public static void main(String[] args) {

	}
}
