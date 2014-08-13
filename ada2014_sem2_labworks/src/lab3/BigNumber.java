package lab3;

import java.math.BigInteger;

public class BigNumber implements Comparable<BigNumber> {

	private String val;

	/**
	 * BigNumber constructor
	 * 
	 * @param val
	 */
	public BigNumber(String val) {
		this.val = val;
	}

	/**
	 * default constructor
	 */
	public BigNumber() {

	}

	/**
	 * only works with two positive numbers
	 * 
	 * @param num1
	 * @param num2
	 * @return the result
	 */
	public String add(String num1, String num2) {
		String result = "", first = num1, second = num2;
		int increment = 0;
		// line up
		first = lineUpLength(num1, num2)[0];
		second = lineUpLength(num1, num2)[1];
		// add
		int sumOfDigits = charToInt(first.charAt(first.length() - 1))
				+ charToInt(second.charAt(second.length() - 1));
		if (sumOfDigits > 9) {
			increment = sumOfDigits / 10;
			sumOfDigits %= 10;
		}
		result += sumOfDigits;
		for (int i = first.length() - 2; i >= 0; i--) {
			sumOfDigits = charToInt(first.charAt(i))
					+ charToInt(second.charAt(i)) + increment;
			// check increment
			if (i == 0) {

			} else if (sumOfDigits > 9) {
				increment = sumOfDigits / 10;
				sumOfDigits %= 10;
			} else {
				increment = 0;
			}
			String temp = "";
			temp += sumOfDigits;
			temp += result;
			result = temp;
			this.val = result;
		}
		return result;
	}

	public String minus(String num1, String num2) {
		String result = "", first = num1, second = num2;
		// always the first minus the second
		int decrements = 0;
		// init step
		if (num1.length() > num2.length()) {
			first = lineUpLength(num1, num2)[0];
			second = lineUpLength(num1, num2)[1];
		} else if (num1.length() < num2.length()) {
			first = lineUpLength(num1, num2)[1];
			second = lineUpLength(num1, num2)[0];
		}
		// following steps
		int minus = charToInt(first.charAt(first.length() - 1))
				- charToInt(second.charAt(second.length() - 1));
		if (minus < 0) {
			minus += 10;
			decrements++;
		}
		result += minus;
		for (int i = first.length() - 2; i >= 0; i--) {
			minus = charToInt(first.charAt(i)) - charToInt(second.charAt(i));
			if (decrements > 0) {
				minus -= 1;
				decrements--;
			}
			if (minus < 0) {
				minus += 10;
				decrements++;
			}
			String temp = "";
			temp += minus;
			temp += result;
			result = temp;
		}
		this.val = result;
		return result;
	}

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiple(String num1, String num2) {
		String result = "", first = num1, second = num2;
		int raised = 0;
		// rules: first number has less digits
		if (first.length() > second.length()) {
			first = num2;
			second = num1;
		}
		String outterZeroes = "";
		for (int i = first.length() - 1; i >= 0; i--) {
			String innerZeroes = "";
			for (int l = second.length() - 1; l >= 0; l--) {
				int mulDigits = charToInt(second.charAt(l))
						* charToInt(first.charAt(i));
				String temp = "";
				temp += mulDigits;
				temp += innerZeroes + outterZeroes;
				innerZeroes += "0";
				// System.out.println(temp + "  " + result);
				result = add(result, temp);
			}
			outterZeroes += "0";
		}
		this.val = result;
		return result;
	}

	/**
	 * line up the numbers
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private String[] lineUpLength(String num1, String num2) {
		if (num1.length() < num2.length()) {
			int diffe = Math.abs(num1.length() - num2.length());
			while (diffe-- > 0) {
				String temp = "0";
				temp += num1;
				num1 = temp;
			}
		} else if (num1.length() > num2.length()) {
			int diffe = Math.abs(num1.length() - num2.length());

			while (diffe-- > 0) {
				String temp = "0";
				temp += num2;
				num2 = temp;
			}
		} else {
			boolean isBiggerFound = false;
			for (int i = 0; i < num1.length() - 1; i++) {
				if (!isBiggerFound) {
					if (charToInt(num1.charAt(i)) > charToInt(num2.charAt(i))) {
						isBiggerFound = true;
					} else if (charToInt(num1.charAt(i)) < charToInt(num2
							.charAt(i))) {
						// swap position
						String temp = num1;
						num1 = num2;
						num1 = temp;
					}
				}
			}
		}
		return new String[] { num1, num2 };
	}

	private int charToInt(char digit) {
		switch (digit) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		default:
			throw new IllegalArgumentException(
					"the number must only contains digits but was " + digit);
		}
	}

	public static BigInteger binaryKaratsuba(BigInteger x, BigInteger y) {

		// cutoff to brute force
		int N = Math.max(x.bitLength(), y.bitLength());
		if (N <= 2000)
			return x.multiply(y); // optimize this parameter

		// number of bits divided by 2, rounded up
		N = (N / 2) + (N % 2);

		// x = a + 2^N b, y = c + 2^N d
		BigInteger b = x.shiftRight(N);
		BigInteger a = x.subtract(b.shiftLeft(N));
		BigInteger d = y.shiftRight(N);
		BigInteger c = y.subtract(d.shiftLeft(N));

		// compute sub-expressions
		BigInteger ac = binaryKaratsuba(a, c);
		BigInteger bd = binaryKaratsuba(b, d);
		BigInteger abcd = binaryKaratsuba(a.add(b), c.add(d));

		return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(
				bd.shiftLeft(2 * N));
	}

	@Override
	/**
	 * @throws NullPointerException when val is not defined 
	 */
	public String toString() {
		return val;
	}

	public static void main(String[] args) {
		BigNumber bn = new BigNumber();
		System.out.println(bn.add("123", "1"));
		System.out.println(bn.add("123", "999"));
		System.out.println(bn.minus("20", "421"));
		System.out.println(bn.minus("99", "421"));
		System.out.println(bn.multiple("232", "6"));
		System.out.println(bn.multiple("232", "10"));
		System.out.println(bn.multiple("232", "11"));
		System.out.println(bn.multiple("232", "110"));
		System.out.println(bn.multiple("232220000000000002",
				"112310000000000000000000000000000"));
		System.out.println(bn.multiple("6", "31"));
	}

	@Override
	public int compareTo(BigNumber arg0) {

		return 0;
	}

	private void removeLeadingZeros(String num) {

	}

}
